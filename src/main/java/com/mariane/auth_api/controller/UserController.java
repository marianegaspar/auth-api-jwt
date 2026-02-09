package com.mariane.auth_api.controller;

import com.mariane.auth_api.model.User;
import com.mariane.auth_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.mariane.auth_api.dto.RegisterRequest;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody RegisterRequest request
    ) {
        userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/me")
    public String me(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return "Usuário logado: " + user.getUsername();
    }
}

