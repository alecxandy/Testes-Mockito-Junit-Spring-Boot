package com.alexandredvlp.testes.com.spring.boot.service.impl;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.exeception.ObjectNotFoundException;
import com.alexandredvlp.testes.com.spring.boot.repository.UserRepository;
import com.alexandredvlp.testes.com.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto nulo!!"));
    }

    @Override
    public List<User> findAll(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
