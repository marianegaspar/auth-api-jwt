package com.mariane.auth_api.dto;

public record LoginResponse(
        String token,
        String username,
        String role
) {}
