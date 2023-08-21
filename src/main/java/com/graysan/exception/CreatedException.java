package com.graysan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 201: Createt
@ResponseStatus(HttpStatus.CREATED)
public class CreatedException extends RuntimeException{

    public CreatedException(String message){
        super(message);
    }
}
