package com.gala.shop.repository.impl;

import com.gala.shop.model.StorageItem;
import com.gala.shop.repository.StorageItemRepository;
import com.gala.shop.repository.datajpa.CrudStorageItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return crudRepository.getOne(id);
    }

    @Override
    public List<StorageItem> getAll() {
        return crudRepository.findAll();
    }

    @Override
    public List<StorageItem> getAllAvailableByCategory(int categoryId) {
        return crudRepository.getAllAvailableByCategory(categoryId);
    }

    @Override
    public List<StorageItem> getAllByCategory(int categoryId) {
        return crudRepository.getAllByCategory(categoryId);
    }

}
