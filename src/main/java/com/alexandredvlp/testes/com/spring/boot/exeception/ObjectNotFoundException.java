package com.alexandredvlp.testes.com.spring.boot.exeception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
