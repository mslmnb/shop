package com.gala.shop.repository.datajpa;

import com.gala.shop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudOrderRepository extends JpaRepository<Order, Integer> {
    @Transactional
    int deleteById(int id);

    @Override
    @Transactional
    Order save(Order storage);

    @Query("SELECT o FROM Order o WHERE o.user.id=:userId AND o.id=:id")
    Order get(@Param("userId") int userId, @Param("id") int id);

    @Query("SELECT o FROM Order o WHERE o.user.id=:userId AND o.completed=:completedCode")
    Order getOne(@Param("userId") int userId, @Param("completedCode") int completedCode);

    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.completed=:completedCode WHERE o.id=:id")
    int setCompleted(@Param("id") int id, @Param("completedCode") int completedCode);
}
