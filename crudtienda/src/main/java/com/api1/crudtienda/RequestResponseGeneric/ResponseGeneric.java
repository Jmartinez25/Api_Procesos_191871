package com.api1.crudtienda.RequestResponseGeneric;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseGeneric {
    private LocalDateTime date;
    private Object message;
    private String statusCode;

    public ResponseGeneric(LocalDateTime date, Object message, String statusCode) {
        this.date = date;
        this.message = message;
        this.statusCode = statusCode;
    }
}
