package com.example.demo.repository;

import com.example.demo.models.Todo;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//CRUD OPS
public interface TodoRepo extends JpaRepository<Todo,Long> {
    Optional<User> findByEmail(String email);
}
