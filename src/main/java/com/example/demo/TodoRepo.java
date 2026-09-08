package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//CRUD OPS
public interface TodoRepo extends JpaRepository<Todo,Long> {

}
