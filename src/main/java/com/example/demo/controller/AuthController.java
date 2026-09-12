package com.example.demo.controller;


import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user/")
public class AuthController {
    @Autowired
    private UserService userservice;

    @PostMapping("/login")
    public String registerUser(@RequestBody Map<String,String> body){
        return "";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String,String> body){
        return "";
    }
}
