package com.example.GrillTogether.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.GrillTogether.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
public class JwtTokenProvider {

    @Value("${spring.datasource.jwtkey}")
    private String jwtKey;

    public String generateToken(User user) {
        return JWT.create()
                .withHeader(Map.of("alg","HS256","typ","jwt"))
                .withClaim("sub", user.getUid().toString())
                .withClaim("email", user.getEmail())
                .withClaim("exp", Instant.now().plusSeconds(60 * 60 * 24 * 30)) // 60s * 60m * 24hr * 30 days
                .withClaim("iat", Instant.now())
                .sign(Algorithm.HMAC256(jwtKey));
    }

    public void setJwtKey(String jwtKey) {
        this.jwtKey = jwtKey;
    }
}
