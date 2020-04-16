package com.gala.shop.service.impl;

import com.gala.shop.model.User;
import com.gala.shop.repository.UserRepository;
import com.gala.shop.service.UserService;
import com.gala.shop.util.exception.NotFoundAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gala.shop.util.ValidationUtil.checkNotFound;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(User user) throws NotFoundAppException{
        if(!user.isNew()) {
            get(user.getId());
        }
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundAppException {
        checkNotFound(repository.delete(id));
    }

    @Override
    public User get(int id) throws NotFoundAppException {
        return checkNotFound(repository.get(id));
    }

    @Override
    public User getByName(String name) throws NotFoundAppException {
        return checkNotFound(repository.getByName(name));
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
