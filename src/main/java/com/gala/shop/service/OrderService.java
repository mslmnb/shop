package com.gala.shop.service;

import com.gala.shop.model.Order;
import com.gala.shop.model.OrderDetails;
import com.gala.shop.model.User;
import com.gala.shop.util.exception.NotAvailableGoodsAppException;
import com.gala.shop.util.exception.NotFoundAppException;

import java.util.List;

public interface OrderService {

    void delete(int userId, int orderId) throws NotFoundAppException;

    List<OrderDetails> getAllOrderDetails(int userId, int orderId) throws NotFoundAppException;

    void setCompleted(int userId, int orderId) throws NotAvailableGoodsAppException;

    Order getBasket(User user);

    OrderDetails addOrderDetails(int userId, int orderId, OrderDetails orderDetails);

    void setCount(int userId, int orderId, int orderDetailsId, int count)
            throws NotFoundAppException, NotAvailableGoodsAppException;

    void remove(int userId, int orderId, int orderDetailsId) throws NotFoundAppException;

}
