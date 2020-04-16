package com.gala.shop.service.impl;

import com.gala.shop.model.StorageItem;
import com.gala.shop.repository.StorageItemRepository;
import com.gala.shop.service.StorageItemService;
import com.gala.shop.util.exception.NotFoundAppException;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Transactional
    public StorageItem save(StorageItem storageItem)  throws NotFoundAppException {
        if(!storageItem.isNew()) {
            get(storageItem.getId());
        }
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
    public List<StorageItem> getAll() {
        return repository.getAll();
    }

    @Override
    public List<StorageItem> getAllAvailableByCategory(int categoryId) {
        return repository.getAllAvailableByCategory(categoryId);
    }

    @Override
    public List<StorageItem> getAllByCategory(int categoryId) {
        return repository.getAllByCategory(categoryId);
    }
}
