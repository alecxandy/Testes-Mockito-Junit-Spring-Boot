package com.alexandredvlp.testes.com.spring.boot.service;

import com.alexandredvlp.testes.com.spring.boot.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll(Long id);
    User save(User user);
}
