package com.example.demo.controller;


import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class AuthController {
    private UserService userservice;
    private UserRepository userrepo;
    private PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password=body.get("password");

        if(userrepo.findByEmail(email).isPresent()){
            return new ResponseEntity<>("User Already Exists", HttpStatus.CONFLICT);
        }
        userservice.createUser(User.builder().email(email).password(password).build());
        return new ResponseEntity<>("User Created Successfully",HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password=body.get("password");

        var optionalUser=userrepo.findByEmail(email);
        if(optionalUser.isEmpty()){
            return new ResponseEntity<>("User Not Registered",HttpStatus.UNAUTHORIZED);
        }
        User user=optionalUser.get();
        if(!passwordEncoder.matches(password, user.getPassword())){
            return new ResponseEntity<>("Invalid Password",HttpStatus.UNAUTHORIZED);
        }
        String token= jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("token",token));
    }
}
