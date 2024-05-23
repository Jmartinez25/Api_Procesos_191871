package com.api1.crudtienda.exception.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BadRequestException extends RuntimeException{
    private String code;
    private HttpStatus status;

    public BadRequestException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
