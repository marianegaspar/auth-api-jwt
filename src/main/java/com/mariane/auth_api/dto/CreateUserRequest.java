package com.mariane.auth_api.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

