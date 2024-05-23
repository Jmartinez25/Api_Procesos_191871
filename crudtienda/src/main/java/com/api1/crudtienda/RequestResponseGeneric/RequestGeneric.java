package com.api1.crudtienda.RequestResponseGeneric;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class RequestGeneric<T> {
    private Timestamp timestamp;
    private T data;
}
