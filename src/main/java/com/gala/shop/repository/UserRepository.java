package com.gala.shop.repository;

import com.gala.shop.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByName(String name);

    List<User> getAll();

}