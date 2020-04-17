package com.gala.shop.repository.impl;

import com.gala.shop.model.Category;
import com.gala.shop.repository.CategoryRepository;
import com.gala.shop.repository.datajpa.CrudCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CrudCategoryRepository crudRepository;

    @Autowired
    public CategoryRepositoryImpl(CrudCategoryRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public List<Category> getAll() {
        return crudRepository.findAll();
    }
}
