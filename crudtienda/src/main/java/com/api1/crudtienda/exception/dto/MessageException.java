package com.api1.crudtienda.exception.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageException {
    private String message;
    private String code;
    private LocalDateTime dateException;

    public MessageException(String message, String code) {
        this.message = message;
        this.code = code;
        this.dateException = LocalDateTime.now();
    }
}
