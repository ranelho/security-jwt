package com.bezkoder.spring.security.postgresql.usuario.application.api;

import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Value
public class UserRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String name;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}