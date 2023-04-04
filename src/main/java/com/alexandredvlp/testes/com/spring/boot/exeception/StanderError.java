package com.alexandredvlp.testes.com.spring.boot.exeception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StanderError {
    private LocalDateTime timeStamp;
    private Integer status;
    private String error;
    private String path;

}

