package com.example.GrillTogether.auth;
import com.example.GrillTogether.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            return new ResponseEntity<>(authService.registerUser(user), HttpStatus.CREATED);
        } catch (IllegalArgumentException exc) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, exc.getMessage(), exc);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            return new ResponseEntity<>(authService.loginUser(loginRequest.getEmail(), loginRequest.getPassword()), HttpStatus.OK);
        } catch (BadCredentialsException exc) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, exc.getMessage(), exc);
        }
    }
}
