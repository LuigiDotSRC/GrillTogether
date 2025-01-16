package com.example.GrillTogether.auth;

import com.example.GrillTogether.user.User;
import com.example.GrillTogether.user.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    //TODO: implement -- see https://github.com/auth0/java-jwt/blob/master/EXAMPLES.md https://javadoc.io/static/com.auth0/java-jwt/4.4.0/com/auth0/jwt/package-summary.htm
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public AuthService(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    //TODO: email verification, OAuth
    public String registerUser(User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email is already registered");
        }

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        User userDBInstance = new User(user.getFirst_name(), user.getLast_name(), user.getEmail(), hashedPassword);

        userService.addUser(userDBInstance);

        return jwtTokenProvider.generateToken(userDBInstance);
    }

    public String loginUser(String email, String password) {
        User user = userService.findByEmail(email);
        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid Credentials");
        }

        return jwtTokenProvider.generateToken(user);
    }
}
