package com.gala.shop.repository.impl;

import com.gala.shop.model.Order;
import com.gala.shop.repository.OrderRepository;
import com.gala.shop.repository.datajpa.CrudOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.gala.shop.util.ConstantUtil.FALSE_CODE;
import static com.gala.shop.util.ConstantUtil.TRUE_CODE;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private CrudOrderRepository crudRepository;

    @Autowired
    public OrderRepositoryImpl(CrudOrderRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Order save(Order order) {
        return crudRepository.save(order);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.deleteById(id) != 0;
    }

    @Override
    public boolean setComplited(int id, boolean complited) {
        return crudRepository.setCompleted(id, complited ? TRUE_CODE : FALSE_CODE) != 0;
    }

    @Override
    public Order get(int userId, boolean complited) {
        return crudRepository.getOne(userId, complited ? TRUE_CODE : FALSE_CODE);
    }

    @Override
    public Order get(int userId, int id) {
        return crudRepository.get(userId, id);
    }
}
