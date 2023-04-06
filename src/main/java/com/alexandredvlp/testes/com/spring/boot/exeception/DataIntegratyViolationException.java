package com.alexandredvlp.testes.com.spring.boot.exeception;

public class DataIntegratyViolationException extends RuntimeException {
    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
