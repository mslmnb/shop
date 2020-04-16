package com.gala.shop.repository.impl;

import com.gala.shop.model.User;
import com.gala.shop.repository.UserRepository;
import com.gala.shop.repository.datajpa.CrudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private CrudUserRepository crudRepository;

    @Autowired
    public UserRepositoryImpl(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudRepository.getOne(id);
    }

    @Override
    public User getByName(String name) {
        return crudRepository.getByName(name);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll();
    }

}
