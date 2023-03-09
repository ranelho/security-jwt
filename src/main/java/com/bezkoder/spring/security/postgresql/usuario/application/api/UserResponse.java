package com.bezkoder.spring.security.postgresql.usuario.application.api;

import com.bezkoder.spring.security.postgresql.usuario.domain.User;
import lombok.Value;

import java.util.UUID;

@Value
public class UserResponse {
    private UUID userId;
    private String usuario;

    public UserResponse(User usuario) {
        this.userId = usuario.getUserId();
        this.usuario = usuario.getUsername();
    }
}