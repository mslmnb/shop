package com.gala.shop.service.impl;

import com.gala.shop.model.Order;
import com.gala.shop.model.OrderDetails;
import com.gala.shop.model.User;
import com.gala.shop.repository.OrderDetailsRepository;
import com.gala.shop.repository.OrderRepository;
import com.gala.shop.service.OrderService;
import com.gala.shop.util.exception.NotAvailableGoodsAppException;
import com.gala.shop.util.exception.NotFoundAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gala.shop.util.ValidationUtil.checkAvailableForModification;
import static com.gala.shop.util.ValidationUtil.checkNotFound;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    @Transactional
    public void delete(int userId, int orderId) throws NotFoundAppException {
        Order order = orderRepository.get(userId, orderId);
        checkNotFound(order);
        checkAvailableForModification(order);
        orderRepository.delete(orderId);
    }

    @Override
    public List<OrderDetails> getAllOrderDetails(int userId, int orderId) throws NotFoundAppException {
        Order order = orderRepository.get(userId, orderId);
        checkNotFound(order);
        return orderDetailsRepository.getAll(orderId);
    }

    @Override
    @Transactional
    public void setCompleted(int userId, int orderId) throws NotAvailableGoodsAppException {
        Order order = orderRepository.get(userId, orderId);
        checkNotFound(order);
        checkAvailableForModification(order);
        checkAvailability(orderId);
        orderRepository.setComplited(orderId, true);
    }

    private void checkAvailability(int orderId) {
        List<OrderDetails> orderDetailsList = orderDetailsRepository.getAll(orderId);
        if (orderDetailsList!=null && orderDetailsList.size()>0)
            orderDetailsList.forEach(orderDetails -> checkAvailability(orderDetails));
    }

    private void checkAvailability(OrderDetails orderDetails) {
        if (orderDetails.getCount()>orderDetails.getStorageItem().getCount()) {
            throw new NotAvailableGoodsAppException("Order contains unaccessible item.");
        }
    }

    @Override
    @Transactional
    public Order getBasket(User user) {
        Order result = orderRepository.get(user.getId(), false);
        if (result==null){
            result = Order.builder().completed(false).user(user).build();
            orderRepository.save(result);
        }
        return result;
    }

    @Override
    @Transactional
    public OrderDetails addOrderDetails(int userId, int orderId, OrderDetails orderDetails) {
        OrderDetails targetOrderDetails;
        Order order = orderRepository.get(userId, orderId);
        checkNotFound(order);
        checkAvailableForModification(order);

        OrderDetails existingOrderDetails = orderDetailsRepository.getByStorageItem(orderId, orderDetails.getStorageItem().getId());
        if (existingOrderDetails!=null) {
            existingOrderDetails.setCount(existingOrderDetails.getCount() + orderDetails.getCount());
            targetOrderDetails = existingOrderDetails;
        } else {
            targetOrderDetails = OrderDetails.builder()
                    .order(order)
                    .storageItem(orderDetails.getStorageItem())
                    .count(orderDetails.getCount()).build();
        }
        checkAvailability(targetOrderDetails);
        return orderDetailsRepository.save(targetOrderDetails);
    }

    @Override
    @Transactional
    public void setCount(int userId, int orderId, int orderDetailsId, int count)
                                                    throws NotFoundAppException, NotAvailableGoodsAppException {
        Order order = orderRepository.get(userId, orderId);
        checkNotFound(order);
        checkAvailableForModification(order);

        OrderDetails targetOrderDetails = orderDetailsRepository.get(orderId, orderDetailsId);
        checkNotFound(targetOrderDetails);

        if (count == 0) {
                orderDetailsRepository.delete(targetOrderDetails.getId());
        } else {
            orderDetailsRepository.setCount(orderDetailsId, count);
        }
    }

    @Override
    @Transactional
    public void remove(int userId, int orderId, int orderDetailsId) throws NotFoundAppException {
        Order order = orderRepository.get(userId, orderId);
        checkNotFound(order);
        checkAvailableForModification(order);

        OrderDetails targetOrderDetails = orderDetailsRepository.get(orderId, orderDetailsId);
        checkNotFound(targetOrderDetails);
        orderDetailsRepository.delete(orderDetailsId);
    }
}
