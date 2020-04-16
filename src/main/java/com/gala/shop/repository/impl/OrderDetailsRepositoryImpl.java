package com.gala.shop.repository.impl;

import com.gala.shop.model.OrderDetails;
import com.gala.shop.repository.OrderDetailsRepository;
import com.gala.shop.repository.datajpa.CrudOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

    private final CrudOrderDetailsRepository crudRepository;

    @Autowired
    public OrderDetailsRepositoryImpl(CrudOrderDetailsRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public OrderDetails save(OrderDetails goods) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.deleteById(id) != 0;
    }

    @Override
    public boolean deleteAll(int orderId) {
        return crudRepository.deleteAll(orderId) != 0;
    }

    @Override
    public OrderDetails get(int orderId, int id) {
        return  crudRepository.get(orderId, id);
    }

    @Override
    public OrderDetails getByStorageItem(int orderId, int storageId) {
        return crudRepository.getByStorageItem(orderId, storageId);
    }

    @Override
    public List<OrderDetails> getAll(int orderId) {
        return crudRepository.getAll(orderId);
    }

    @Override
    public void setCount(int orderDetailsId, int count) {
        crudRepository.setCount(orderDetailsId, count);
    }
}
