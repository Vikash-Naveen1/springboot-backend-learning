package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService tos;
    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo){
        return new ResponseEntity<>(tos.createTodo(todo), HttpStatus.CREATED);
    }
    @GetMapping("/{val}")
    ResponseEntity<Todo> getUserId(@PathVariable long val){
        try{
            Todo getUser=tos.getId(val);
            return new ResponseEntity<>(getUser,HttpStatus.OK);
        } catch(RuntimeException e){
            return new ResponseEntity<>((HttpHeaders) null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    ResponseEntity<List<Todo>> getAll(){
        return new ResponseEntity<List<Todo>>(tos.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
        return new ResponseEntity<>(tos.updateById(todo),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id){
        tos.deleteById(id);
    }
}
