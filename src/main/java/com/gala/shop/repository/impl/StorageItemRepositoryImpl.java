package com.gala.shop.repository.impl;

import com.gala.shop.model.StorageItem;
import com.gala.shop.repository.StorageItemRepository;
import com.gala.shop.repository.datajpa.CrudStorageItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.gala.shop.util.ConstantUtil.FALSE_CODE;
import static com.gala.shop.util.ConstantUtil.TRUE_CODE;

@Repository
public class StorageItemRepositoryImpl implements StorageItemRepository {

    private final CrudStorageItemRepository crudRepository;

    @Autowired
    public StorageItemRepositoryImpl(CrudStorageItemRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public StorageItem save(StorageItem storageItem) {
        return crudRepository.save(storageItem);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public boolean setAvailable(int id, boolean available) {
        return crudRepository.setAvailable(id, available ? TRUE_CODE : FALSE_CODE)!= 0;
    }

    @Override
    public StorageItem get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<StorageItem> getAll() {
        return crudRepository.findAll();
    }

    @Override
    public Page<StorageItem> getAllAvailableByCategory(int categoryId, Pageable pageRequest) {
        return crudRepository.getAllAvailableByCategory(categoryId, pageRequest);
    }

    @Override
    public Page<StorageItem> getAllByCategory(int categoryId, Pageable pageRequest) {
        return crudRepository.getAllByCategory(categoryId, pageRequest);
    }

}
