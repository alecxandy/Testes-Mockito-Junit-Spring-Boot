package com.alexandredvlp.testes.com.spring.boot.repository;

import com.alexandredvlp.testes.com.spring.boot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
