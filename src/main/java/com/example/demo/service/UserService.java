package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepo;

    public User createUser(User us){
        return userrepo.save(us);
    }

    public User getById(Long id){
        return userrepo.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
    }
}
