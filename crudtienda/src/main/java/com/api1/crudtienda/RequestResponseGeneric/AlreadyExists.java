package com.api1.crudtienda.RequestResponseGeneric;

public class AlreadyExists extends RuntimeException {

    public AlreadyExists(String message) {
        super(message);
    }
}
