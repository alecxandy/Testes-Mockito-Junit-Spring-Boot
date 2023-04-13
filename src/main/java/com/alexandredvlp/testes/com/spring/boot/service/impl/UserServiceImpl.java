package com.alexandredvlp.testes.com.spring.boot.service.impl;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.dto.UserDTO;
import com.alexandredvlp.testes.com.spring.boot.exeception.DataIntegratyViolationException;
import com.alexandredvlp.testes.com.spring.boot.exeception.ObjectNotFoundException;
import com.alexandredvlp.testes.com.spring.boot.repository.UserRepository;
import com.alexandredvlp.testes.com.spring.boot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto nulo!!"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserDTO dto) {
        findByEmail(dto);
        return userRepository.save(modelMapper.map(dto, User.class));
    }


    @Override
    public Optional<User> findByEmail(UserDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new DataIntegratyViolationException("Email já cadastrado"));
        return Optional.of(user);
    }

    @Override
    public User update(UserDTO userDTO) {
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, User.class));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
