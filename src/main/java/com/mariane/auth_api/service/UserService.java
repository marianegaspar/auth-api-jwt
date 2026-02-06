package com.mariane.auth_api.service;

import com.mariane.auth_api.auth.Role;
import com.mariane.auth_api.dto.LoginRequest;
import com.mariane.auth_api.dto.LoginResponse;
import com.mariane.auth_api.exception.AuthException;
import com.mariane.auth_api.model.User;
import com.mariane.auth_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mariane.auth_api.dto.RegisterRequest;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;


    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User register(RegisterRequest request) {

        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new AuthException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new AuthException("Senha inválida");
        }

        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(
                token,
                user.getUsername(),
                user.getRole().name()
        );
    }


}
