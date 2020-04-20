package com.gala.shop.repository;

import com.gala.shop.model.StorageItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StorageItemRepository {
    StorageItem save(StorageItem storageItem);

    // false if not found
    boolean delete(int id);

    // false if not found
    boolean setAvailable(int id, boolean available);

    // null if not found
    StorageItem get(int id);

    Page<StorageItem> getAll(Pageable pageRequest);

    Page<StorageItem> getAllAvailableByCategory(int categoryId, Pageable pageRequest);

    Page<StorageItem> getAllByCategory(int categoryId, Pageable pageRequest);
}
