package com.graysan.business.services.impl;

import com.graysan.bean.ModelMapperBean;
import com.graysan.business.dto.CategoryDto;
import com.graysan.business.services.ICategoryServices;
import com.graysan.data.entity.CategoryEntity;
import com.graysan.data.repository.ICategoryRepository;
import com.graysan.exception.BlogNotFoundException;
import com.graysan.exception.GraysanException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2
// SERVICE
@Service
public class CategoryServiceImpl implements ICategoryServices<CategoryDto, CategoryEntity> {

    // Injection
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    @Override
    public CategoryDto entityToDto(CategoryEntity categoryEntity) {
        return modelMapperBean.modelMapperMethod().map(categoryEntity,CategoryDto.class);
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDto categoryDto) {
        return modelMapperBean.modelMapperMethod().map(categoryDto, CategoryEntity.class);
    }

    // Create
    @Override
    @Transactional // create , update , delete
    public CategoryDto categoryServiceCreate(CategoryDto categoryDto) {
        if (categoryDto != null){
            CategoryEntity dtoToEntityChange = dtoToEntity(categoryDto);
            CategoryEntity categoryEntity = iCategoryRepository.save(dtoToEntityChange);
            // kaydettikten sonra id alsın döndersin
            categoryDto.setId(categoryEntity.getCategoryId());
            categoryDto.setSystemDate(categoryEntity.getSystemDate());

        }else {
            throw new NullPointerException("Category Dto null");
        }
        return categoryDto;
    }
    // List
    @Override
    public List<CategoryDto> categoryServiceList() {
        // CategoryEntity List
        Iterable<CategoryEntity> categoryEntitiesList = iCategoryRepository.findAll();

        // CategoryDto List
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        // Bu döngü EntityList'i DtoList'e çevirsin
        for (CategoryEntity entity : categoryEntitiesList) {
            CategoryDto categoryDto = entityToDto(entity);
            categoryDtoList.add(categoryDto);
            // eğer DB masking yapmak istiyorsak Bcrypted kullanabiliriz
        }
        return categoryDtoList;
    }
    // Find
    @Override
    public CategoryDto categoryServiceFind(Long id) {
        // 1. Yol - Optional get, isPresent
        /*Optional<CategoryEntity> categoryFindEntity = iCategoryRepository.findById(id);
        CategoryDto categoryDto = entityToDto(categoryFindEntity.get());
        if (categoryFindEntity.isPresent()){
            return categoryDto;
        }*/

        // 2. Yol
        CategoryEntity categoryEntity = null;
        if(id != null && id != 0){
            categoryEntity = iCategoryRepository.findById(id)
                    .orElseThrow(() -> new BlogNotFoundException(id + " Nolu ID Bulunamadı.."));
        } else if (id == null)
            throw new GraysanException("Category id null değerdir");

        return entityToDto(categoryEntity);
    }
    // Update
    @Override
    @Transactional // create , update , delete
    public CategoryDto categoryServiceUpdate(Long id, CategoryDto categoryDto) {
        // Öncelikle Nesneyi bul
        CategoryDto categoryFindDto = categoryServiceFind(id);
        if (categoryFindDto != null){
            CategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            categoryEntity.setCategoryName(categoryDto.getCategoryName());
            iCategoryRepository.save(categoryEntity);
        }
        return categoryDto;
    }
    // Delete
    @Override
    @Transactional // create , update , delete
    public CategoryDto categoryServiceDelete(Long id) {
        // Öncelikle Nesneyi bul
        CategoryDto categoryFindDto = categoryServiceFind(id);
        if (categoryFindDto != null){
            CategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            iCategoryRepository.delete(categoryEntity);
        }
        return categoryFindDto;
    }

    // All Delete
    @Override
    public String categoryServiceAllDelete() {
        iCategoryRepository.deleteAll();
        return "Silinen veri sayısı : " + categoryServiceList().size();
    }

    // Speed Data
    @Override
    public List<CategoryDto> categoryServiceSpeedData(int key) {
        CategoryDto categoryDto = null;
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= key; i++) {
            categoryDto = new CategoryDto();
            categoryDto.setCategoryName("category adı: " + i);
            categoryDtoList.add(categoryDto);
            CategoryEntity categoryEntity=dtoToEntity(categoryDto);
            iCategoryRepository.save(categoryEntity);
            count++;
        }
        return categoryDtoList;
    }


}
