package com.example.GrillTogether.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.GrillTogether.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class JwtTokenProviderTest {

    @InjectMocks
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private Algorithm mockAlgorithm;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        jwtTokenProvider = new JwtTokenProvider();
        jwtTokenProvider.setJwtKey("testSecretKey");
    }

    @Test
    void testGenerateToken() {
        // ARRANGE: create mock user
        User user = new User();
        user.setUid(123L);
        user.setEmail("test@example.com");

        // ACT: create token
        String token = jwtTokenProvider.generateToken(user);

        // ASSERT: decode token and validate claims
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("testSecretKey")).build().verify(token);

        assertNotNull(decodedJWT);
        assertEquals("123", decodedJWT.getClaim("sub").asString());
        assertEquals("test@example.com", decodedJWT.getClaim("email").asString());
        assertNotNull(decodedJWT.getClaim("exp"));
        assertNotNull(decodedJWT.getClaim("iat"));

        Instant now = Instant.now();
        int secondsBuffer = 60;
        assertTrue(decodedJWT.getClaim("exp").asInstant().isAfter(now));
        assertTrue(decodedJWT.getClaim("exp").asInstant().isBefore(now.plusSeconds(60 * 60 * 24 * 30 + secondsBuffer)));

        assertEquals("HS256", decodedJWT.getHeaderClaim("alg").asString());
    }

}
