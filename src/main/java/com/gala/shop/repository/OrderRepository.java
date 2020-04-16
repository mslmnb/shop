package com.gala.shop.repository;

import com.gala.shop.model.Order;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    // false if not found
    boolean delete(int id);

    // false if not found
    boolean setComplited(int id, boolean complited);

    Order get(int userId, boolean complited);

    Order get(int userId, int id);
}
