package com.example.demo;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController

public class TodoController {
    @Autowired
    private TodoService tos;

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo){
        return new ResponseEntity<>(tos.createTodo(todo), HttpStatus.CREATED);
    }
    @ApiResponses(value={
            @ApiResponse(responseCode = "200",description = "Todo created Successfully"),
            @ApiResponse(responseCode = "404",description = "Todo not found")
    })
    @GetMapping("/{val}")
    ResponseEntity<Todo> getUserId(@PathVariable long val){
        try{
            Todo getUser=tos.getId(val);
            return new ResponseEntity<>(getUser,HttpStatus.OK);
        } catch(RuntimeException e){
            log.info("Error");
            log.warn("Alert");
            log.error("",e);
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

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPage(@RequestParam int page,@RequestParam int size){
        return new ResponseEntity<>(tos.getAllTodosPages(page,size),HttpStatus.OK);
    }
}
