package com.gala.shop.repository.datajpa;

import com.gala.shop.model.StorageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudStorageItemRepository extends JpaRepository<StorageItem, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM StorageItem s WHERE s.id=:id")
    int delete(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE StorageItem s SET s.available=:availableCode WHERE s.id=:id")
    int setAvailable(@Param("id") int id, @Param("availableCode") int availableCode);

    @Override
    @Transactional
    StorageItem save(StorageItem storageItem);

    @Override
    StorageItem getOne(Integer id);

    @Override
    List<StorageItem> findAll();

    @Query("SELECT s FROM StorageItem s WHERE s.category.id=:categoryId AND s.available=1")
    List<StorageItem> getAllAvailableByCategory(@Param("categoryId") int categoryId);

    @Query("SELECT s FROM StorageItem s WHERE s.category.id=:categoryId")
    List<StorageItem> getAllByCategory(@Param("categoryId") int categoryId);
}
