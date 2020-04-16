package com.gala.shop.repository;

import com.gala.shop.model.StorageItem;

import java.util.List;

public interface StorageItemRepository {
    StorageItem save(StorageItem storageItem);

    // false if not found
    boolean delete(int id);

    // false if not found
    boolean setAvailable(int id, boolean available);

    // null if not found
    StorageItem get(int id);

    List<StorageItem> getAll();

    List<StorageItem> getAllAvailableByCategory(int categoryId);

    List<StorageItem> getAllByCategory(int categoryId);
}
