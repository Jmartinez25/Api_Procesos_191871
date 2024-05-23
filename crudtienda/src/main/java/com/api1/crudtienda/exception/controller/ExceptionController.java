package com.api1.crudtienda.exception.controller;

import com.api1.crudtienda.exception.dto.MessageException;
import com.api1.crudtienda.exception.exceptions.BadRequestException;
import com.api1.crudtienda.exception.exceptions.NotFoundExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageException> exceptioBadRequest(BadRequestException ex){
        return new ResponseEntity<>(new MessageException(ex.getMessage(),ex.getCode()),ex.getStatus());
    }

    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<MessageException> exceptioExeption(NotFoundExeption ex){
        return new ResponseEntity<>(new MessageException(ex.getMessage(),ex.getCode()),ex.getStatus());
    }
}
