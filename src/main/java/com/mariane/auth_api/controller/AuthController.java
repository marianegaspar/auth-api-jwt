package com.mariane.auth_api.controller;

import com.mariane.auth_api.dto.LoginRequest;
import com.mariane.auth_api.dto.LoginResponse;
import com.mariane.auth_api.model.User;
import com.mariane.auth_api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mariane.auth_api.dto.RegisterRequest;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        System.out.println("REQUEST => " + request);
        return userService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }


}


