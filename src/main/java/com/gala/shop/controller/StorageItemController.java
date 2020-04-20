package com.gala.shop.controller;

import com.gala.shop.model.TO.StorageItemTO;
import com.gala.shop.service.StorageItemService;
import com.gala.shop.util.TOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    Page<StorageItemTO> getAllAvailableByCategory(@RequestParam(value = "category") int categoryId,
                                                  Pageable pageRequest) {
        List<StorageItemTO> resultContent = service.getAllAvailableByCategory(categoryId, pageRequest).getContent()
                .stream()
                .map(storageItem -> TOUtil.asTO(storageItem))
                .collect(Collectors.toList());
        return new PageImpl<>(resultContent, pageRequest, resultContent.size());
    }
}
