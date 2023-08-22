package com.graysan.data.repository;


import com.graysan.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// JpaRepository - Alttakilerin hepsini kapsar
// CrudRepository
// PagingAndSortingRepository

@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity, Long> {

    // Delivered Query
    BlogEntity findBlogEntityByBlogEntityEmbeddableHeader(String header);
}
