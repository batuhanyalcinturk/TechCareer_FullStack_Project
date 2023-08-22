package com.graysan.business.services;

import com.graysan.business.dto.CategoryDto;

import java.util.List;

// Generics
// D: Dto
// E: Entity
public interface ICategoryServices<D,E> {

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    // CRUD
    // Create
    public D categoryServiceCreate(D d);
    // List
    public List<D> categoryServiceList();
    // Find
    public D categoryServiceFind(Long id);
    // Update
    public D categoryServiceUpdate(Long id, D d);
    // Delete
    public D categoryServiceDelete(Long id);
    ////////////////////////////////////
    // All Delete
    public String categoryServiceAllDelete();
    // Speed Data
    public List<CategoryDto> categoryServiceSpeedData(Long key);

}
