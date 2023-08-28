package com.graysan.data.repository;

import com.graysan.data.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// JpaRepository - Alttakilerin hepsini kapsar
// CrudRepository
// PagingAndSortingRepository
@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long> {
    // Delivered Query (Kendi sorgumu yazdım)
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
