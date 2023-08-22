package com.graysan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 201: Created
@ResponseStatus(HttpStatus.CREATED)
public class BlogCreatedException extends RuntimeException{

    public BlogCreatedException(String message){
        super(message);
    }
}