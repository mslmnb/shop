package com.gala.shop.service.impl;

import com.gala.shop.model.Category;
import com.gala.shop.model.StorageItem;
import com.gala.shop.repository.StorageItemRepository;
import com.gala.shop.service.StorageItemService;
import com.gala.shop.util.exception.NotFoundAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.gala.shop.util.ValidationUtil.checkNotFound;

@Service
public class StorageItemServiceImpl implements StorageItemService {
    private final StorageItemRepository repository;

    @Autowired
    public StorageItemServiceImpl(StorageItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public StorageItem create(StorageItem storageItem, int categoryId)  throws NotFoundAppException {
        storageItem.setId(null);
        storageItem.setCategory(Category.builder().id(categoryId).build());
        return repository.save(storageItem);
    }

    @Override
    @Transactional
    public StorageItem update(int id, StorageItem storageItem)  throws NotFoundAppException {
        StorageItem targetStorageItem = get(id);
        storageItem.setId(id);
        storageItem.setCategory(targetStorageItem.getCategory());
        return repository.save(storageItem);
    }

    @Override
    public void delete(int id) throws NotFoundAppException {
        checkNotFound(repository.delete(id));
    }

    @Override
    public void setAvailable(int id, boolean available) throws NotFoundAppException {
        checkNotFound(repository.setAvailable(id, available));
    }

    @Override
    public StorageItem get(int id) {
        return checkNotFound(repository.get(id));
    }

    @Override
    public Page<StorageItem> getAll(Pageable pageRequest) {
        return repository.getAll(pageRequest);
    }

    @Override
    public Page<StorageItem> getAllAvailableByCategory(int categoryId, Pageable pageRequest) {
        return repository.getAllAvailableByCategory(categoryId, pageRequest);
    }

    @Override
    public Page<StorageItem> getAllByCategory(int categoryId, Pageable pageRequest) {
        return repository.getAllByCategory(categoryId, pageRequest);
    }
}
