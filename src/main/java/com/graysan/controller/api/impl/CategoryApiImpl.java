package com.graysan.controller.api.impl;

import com.graysan.assist.FrontEnd;
import com.graysan.business.dto.CategoryDto;
import com.graysan.business.services.ICategoryServices;
import com.graysan.controller.api.ICategoryApi;
import com.graysan.error.ApiResult;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Lombok
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@RequestMapping("/category/api/v1")
@CrossOrigin(origins = FrontEnd.REACT_URL)
public class CategoryApiImpl implements ICategoryApi<CategoryDto> {

    // Injection
    private final ICategoryServices iCategoryServices;
    private ApiResult apiResult;

    //
    @PostConstruct
    public void categoryPostConstruct(){
        apiResult = new ApiResult();
    }

    @Override
    public ResponseEntity<?> categoryApiCreate(@Valid @RequestBody CategoryDto categoryDto) {
        // return new ResponseEntity<>(iCategoryServices.categoryServiceCreate(categoryDto), HttpStatus.OK);
        // return ResponseEntity.status(HttpStatus.OK).body(iCategoryServices.categoryServiceCreate(categoryDto));
        // return ResponseEntity.status(200).body(iCategoryServices.categoryServiceCreate(categoryDto));
        //return ResponseEntity.ok().body(iCategoryServices.categoryServiceCreate(categoryDto));
        /*iCategoryServices.categoryServiceCreate(categoryDto);
        apiResult = new ApiResult("path", "message", 200);
        return ResponseEntity.ok().body(apiResult);
        */
        return ResponseEntity.ok(iCategoryServices.categoryServiceCreate(categoryDto));
    }

    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiList() {
        return null;
    }

    @Override
    public ResponseEntity categoryApiFind(Long id) {
        return null;
    }

    @Override
    public ResponseEntity categoryApiUpdate(Long id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public ResponseEntity categoryApiDelete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<String> categoryApiAllDelete() {
        return null;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiSpeedData(int key) {
        return null;
    }
}
