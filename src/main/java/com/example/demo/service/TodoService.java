package com.example.demo.service;

import com.example.demo.models.Todo;
import com.example.demo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todorep;

    public Todo createTodo(Todo todo){
        return todorep.save(todo);
    }

    public Todo getId(long id){
//        return todorep.getReferenceById(id);
        return todorep.findById(id).orElseThrow(()->new RuntimeException("Todo not found"));
    }

    public Page<Todo> getAllTodosPages(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        return todorep.findAll(pageable);
    }

    public List<Todo> getAll(){
        return todorep.findAll();
    }

    public Todo updateById(Todo todo){
        return todorep.save(todo);
    }

    public void deleteById(long id){
        todorep.delete(getId(id));
    }

    public void delete(Todo todo){
        todorep.delete(todo);
    }
}
