package com.gala.shop.service;

import com.gala.shop.model.StorageItem;
import com.gala.shop.util.exception.NotFoundAppException;

import java.util.List;

public interface StorageItemService {
    StorageItem save(StorageItem storageItem);

    void delete(int id) throws NotFoundAppException;

    void setAvailable(int id, boolean available) throws NotFoundAppException;

    StorageItem get(int id);

    List<StorageItem> getAll();

    List<StorageItem> getAllAvailableByCategory(int categoryId);

    List<StorageItem> getAllByCategory(int categoryId);
}
