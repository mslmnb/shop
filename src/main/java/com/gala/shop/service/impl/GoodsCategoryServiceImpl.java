package com.gala.shop.service.impl;

import com.gala.shop.model.Category;
import com.gala.shop.repository.GoodsCategoryRepository;
import com.gala.shop.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    private final GoodsCategoryRepository repository;

    @Autowired
    public GoodsCategoryServiceImpl(GoodsCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository.getAll();
    }
}
