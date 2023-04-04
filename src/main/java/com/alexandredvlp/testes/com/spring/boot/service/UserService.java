package com.alexandredvlp.testes.com.spring.boot.service.impl;

import com.alexandredvlp.testes.com.spring.boot.domain.User;

import java.util.List;

public interface UserServiceImpl {

    List<User> findAll(Long id);

    User save(User user);
}
