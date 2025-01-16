package com.example.GrillTogether.auth;

import com.example.GrillTogether.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/register")
    public String register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
