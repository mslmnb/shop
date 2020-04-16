package com.gala.shop.controller;

import com.gala.shop.model.TO.StorageItemTO;
import com.gala.shop.service.StorageItemService;
import com.gala.shop.util.TOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/shop/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    private final StorageItemService service;

    @Autowired
    public AdminController(StorageItemService service) {
        this.service = service;
    }

    @GetMapping("/storage")
    public List<StorageItemTO> getAll() {
        return service.getAll()
                .stream()
                .map(storageItem -> TOUtil.asTO(storageItem))
                .collect(Collectors.toList());
    }

    @GetMapping("/storage/category/{categoryId}")
    public List<StorageItemTO> getAllByCategory(@PathVariable int categoryId) {
        return service.getAllByCategory(categoryId)
                .stream()
                .map(storageItem -> TOUtil.asTO(storageItem))
                .collect(Collectors.toList());
    }

    @GetMapping("/storage/{id}")
    public  StorageItemTO get(@PathVariable int id) {
        return TOUtil.asTO(service.get(id));
    }

    @DeleteMapping("/storage/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/storage", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity create(@RequestBody @Valid StorageItemTO storageItemTO) {
        service.save(TOUtil.createFrom(storageItemTO));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
