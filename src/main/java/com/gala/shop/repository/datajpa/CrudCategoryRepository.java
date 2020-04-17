package com.gala.shop.repository.datajpa;

import com.gala.shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudCategoryRepository extends JpaRepository<Category, Integer> {
    @Override
    List<Category> findAll();
}
