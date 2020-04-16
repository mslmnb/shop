package com.gala.shop.repository;

import com.gala.shop.model.Category;

import java.util.List;

public interface GoodsCategoryRepository {
    List<Category> getAll();
}
