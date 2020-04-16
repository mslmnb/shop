package com.gala.shop.service;

import com.gala.shop.model.User;
import com.gala.shop.util.exception.NotFoundAppException;

import java.util.List;

public interface UserService {
    User save(User user) throws NotFoundAppException;

    void delete(int id) throws NotFoundAppException;

    User get(int id) throws NotFoundAppException;

    User getByName(String name) throws NotFoundAppException;

    List<User> getAll();
}
