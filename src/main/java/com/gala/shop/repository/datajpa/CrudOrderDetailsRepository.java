package com.gala.shop.repository.datajpa;

import com.gala.shop.model.Order;
import com.gala.shop.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudOrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    @Transactional
    int deleteById(int id);

    @Transactional
    @Modifying
    @Query("DELETE FROM OrderDetails od WHERE od.order.id=:orderId")
    int deleteAll(@Param("orderId") int orderId);

    @Override
    @Transactional
    OrderDetails save(OrderDetails orderDetails);

    @Query("SELECT od FROM OrderDetails od WHERE od.order.id=:orderId AND od.id=:id")
    OrderDetails get(@Param("orderId") int orderId, @Param("id") int id);

    @Query("SELECT od FROM OrderDetails od WHERE od.order.id=:orderId AND od.storageItem.id=:storageItemId")
    OrderDetails getByStorageItem(@Param("orderId") int orderId, @Param("storageItemId") int storageItemId);

    @Query("SELECT od FROM OrderDetails od WHERE od.order.id=:orderId")
    List<OrderDetails> getAll(@Param("orderId") int orderId);

    @Transactional
    @Modifying
    @Query("UPDATE OrderDetails od SET od.count=:count WHERE od.id=:orderDetailsId")
    void setCount(@Param("orderDetailsId") int orderDetailsId, @Param("count") int count);
}
