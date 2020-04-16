package com.gala.shop.repository;

import com.gala.shop.model.OrderDetails;

import java.util.List;

public interface OrderDetailsRepository {
    OrderDetails save(OrderDetails goods);

    // false if not found
    boolean delete(int id);

    // false if not found
    boolean deleteAll(int orderId);

    // null if not found
    OrderDetails get(int orderId, int id);

    // null if not found
    OrderDetails getByStorageItem(int orderId, int storageItemId);

    List<OrderDetails> getAll(int orderId);

    void setCount(int orderDetailsId, int count);
}
