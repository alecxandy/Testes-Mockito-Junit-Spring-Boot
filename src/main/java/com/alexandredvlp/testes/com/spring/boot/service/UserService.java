package com.alexandredvlp.testes.com.spring.boot.service;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    User save(UserDTO dto);
    void findByEmail(UserDTO dto);
    User Update(UserDTO userDTO);
}
