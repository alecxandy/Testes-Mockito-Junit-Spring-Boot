package com.alexandredvlp.testes.com.spring.boot.resource;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.dto.UserDTO;
import com.alexandredvlp.testes.com.spring.boot.repository.UserRepository;
import com.alexandredvlp.testes.com.spring.boot.service.impl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserResourceTest {
    public static final long ID = 1L;
    public static final String NAME = "Alexandre";
    public static final String EMAIL = "Alec@gmail";
    public static final String PASSWORD = "123";
    @Mock
    private ModelMapper modelMapper;
    @Mock//instancia real
    private UserServiceImpl userService;
    @InjectMocks
    private UserResource resource;
    private User user;

    private UserDTO userDTO;

    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        startUser();
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
    }

    @Test
    void WheFindByIdThenRetonrSucess() {
        Mockito.when(userService.findById(Mockito.anyLong())).thenReturn(user);
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resource.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(ResponseEntity.class, response.getClass());
        Assertions.assertEquals(UserDTO.class, response.getBody().getClass());

        Assertions.assertEquals(ID, response.getBody().getId());
        Assertions.assertEquals(NAME, response.getBody().getName());
        Assertions.assertEquals(PASSWORD, response.getBody().getPassword());
        Assertions.assertEquals(EMAIL, response.getBody().getEmail());

    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    public void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = optionalUser.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}