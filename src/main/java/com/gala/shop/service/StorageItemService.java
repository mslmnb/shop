package com.gala.shop.service;

import com.gala.shop.model.StorageItem;
import com.gala.shop.util.exception.NotFoundAppException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StorageItemService {
    StorageItem create(StorageItem storageItem, int categoryId);

    StorageItem update(int id, StorageItem storageItem);

    void delete(int id) throws NotFoundAppException;

    void setAvailable(int id, boolean available) throws NotFoundAppException;

    StorageItem get(int id);

    List<StorageItem> getAll();

    Page<StorageItem> getAllAvailableByCategory(int categoryId, Pageable pageRequest);

    Page<StorageItem> getAllByCategory(int categoryId, Pageable pageRequest);
}
