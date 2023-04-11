package com.alexandredvlp.testes.com.spring.boot.service.impl;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.dto.UserDTO;
import com.alexandredvlp.testes.com.spring.boot.exeception.ObjectNotFoundException;
import com.alexandredvlp.testes.com.spring.boot.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

class UserServiceImplTest {
    public static final long ID = 1L;
    public static final String NAME = "Alexandre";
    public static final String EMAIL = "Alec@gmail";
    public static final String PASSWORD = "123";

    @InjectMocks//instancia real
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    //mocks são metodos aue esta dentro do seu metodo de teste
    @Mock
    private ModelMapper modelMapper;

    private User user;

    private UserDTO userDTO;

    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        startUser();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(optionalUser);
        User response = userService.findById(ID);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(User.class, response.getClass());
    }

    @Test
    void notFindById() {
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenThrow(new ObjectNotFoundException("null"));
        try {
        } catch (Exception e) {
            Assertions.assertEquals(ObjectNotFoundException.class, e.getClass());
            Assertions.assertEquals("null", e.getMessage());
        }
    }

    @Test
    void findAll() {
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user));
        List<User> response = userService.findAll();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(User.class, response.get(0).getClass());
        Assertions.assertEquals(ID, response.get(0).getId());
    }

    @Test
    void save() {
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        User response = userService.save(userDTO);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(User.class,response.getClass());
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(NAME, response.getName());
        Assertions.assertEquals(PASSWORD, response.getPassword());
        Assertions.assertEquals(EMAIL, response.getEmail());
    }


    @Test
    void findByEmail() {
    }

    @Test
    void update() {
    }

    public void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = optionalUser.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}