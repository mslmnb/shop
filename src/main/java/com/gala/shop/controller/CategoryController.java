package com.gala.shop.controller;

import com.gala.shop.model.TO.CategoryTO;
import com.gala.shop.service.CategoryService;
import com.gala.shop.util.TOUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/shop/storage/categories", produces = MediaType.APPLICATION_JSON_VALUE)

public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoryTO> getAll() {
        return service.getAll()
                .stream()
                .map(category -> TOUtil.asTO(category))
                .collect(Collectors.toList());
    }
}
