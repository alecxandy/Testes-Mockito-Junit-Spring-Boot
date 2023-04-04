package com.alexandredvlp.testes.com.spring.boot.config;


import com.alexandredvlp.testes.com.spring.boot.domain.User;
import com.alexandredvlp.testes.com.spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB() {
        User user1 = new User(1L, "Alex", "alecxandy@gmail.com", "123");
        User user2 = new User(2L, "Luiz", "Luiz@gmail.com", "123");

        userRepository.saveAll(List.of(user1, user2));

    }


}
