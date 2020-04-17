package com.gala.shop.repository.datajpa;

import com.gala.shop.model.StorageItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudStorageItemRepository extends PagingAndSortingRepository<StorageItem, Integer> {

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
    Optional<StorageItem> findById(Integer id);

    @Override
    List<StorageItem> findAll();

    @Query("SELECT s FROM StorageItem s WHERE s.category.id=:categoryId AND s.available=1")
    Page<StorageItem> getAllAvailableByCategory(@Param("categoryId") int categoryId, Pageable pageRequest);

    @Query("SELECT s FROM StorageItem s WHERE s.category.id=:categoryId")
    Page<StorageItem> getAllByCategory(@Param("categoryId") int categoryId, Pageable pageRequest);
}
