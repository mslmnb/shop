package com.gala.shop.repository.impl;

import com.gala.shop.model.Category;
import com.gala.shop.repository.GoodsCategoryRepository;
import com.gala.shop.repository.datajpa.CrudGoodsCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsCategoryRepositoryImpl implements GoodsCategoryRepository {
    private final CrudGoodsCategoryRepository crudRepository;

    @Autowired
    public GoodsCategoryRepositoryImpl(CrudGoodsCategoryRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public List<Category> getAll() {
        return crudRepository.findAll();
    }
}
