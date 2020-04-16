package com.gala.shop.controller;

import com.gala.shop.model.StorageItem;
import com.gala.shop.model.TO.StorageItemTO;
import com.gala.shop.service.StorageItemService;
import com.gala.shop.util.TOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/shop/storage", produces = MediaType.APPLICATION_JSON_VALUE)

public class StorageItemController {
    private final StorageItemService service;

    @Autowired
    public StorageItemController(StorageItemService service) {
        this.service = service;
    }

    @GetMapping("/category/{categoryId}")
    List<StorageItemTO> getAllAvailableByCategory(@PathVariable int categoryId) {
        List<StorageItem> l =service.getAllAvailableByCategory(categoryId);
        return service.getAllAvailableByCategory(categoryId)
                .stream()
                .map(storageItem -> TOUtil.asTO(storageItem))
                .collect(Collectors.toList());
    }
}