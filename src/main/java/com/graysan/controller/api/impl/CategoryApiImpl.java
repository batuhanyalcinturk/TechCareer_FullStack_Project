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
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/create")
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
    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> categoryApiList() {
        return ResponseEntity.ok(iCategoryServices.categoryServiceList());
    }

    @Override
    @GetMapping("/find")
    public ResponseEntity categoryApiFind(Long id) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceFind(id));
    }

    @Override
    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> categoryApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceUpdate(id, categoryDto));
    }

    @Override
    @PutMapping("/delete/{id}")
    public ResponseEntity categoryApiDelete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceDelete(id));
    }

    @Override
    @GetMapping(value = "/all/delete")
    public ResponseEntity<String> categoryApiAllDelete() {
        return ResponseEntity.ok(iCategoryServices.categoryServiceAllDelete());
    }

    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiSpeedData(Long key) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceSpeedData(key));
    }
}
