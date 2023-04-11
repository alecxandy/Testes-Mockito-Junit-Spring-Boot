package com.alexandredvlp.testes.com.spring.boot.resource;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.dto.UserDTO;
import com.alexandredvlp.testes.com.spring.boot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(userService.save(dto), UserDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(modelMapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> userDTOS = userService.findAll()
                .stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto) {
        dto.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(userService.save(dto), UserDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
