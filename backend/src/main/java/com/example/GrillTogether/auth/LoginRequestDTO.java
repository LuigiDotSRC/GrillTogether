package com.example.GrillTogether.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @Email
    private String email;

    @Size(min = 8)
    private String password;
}
