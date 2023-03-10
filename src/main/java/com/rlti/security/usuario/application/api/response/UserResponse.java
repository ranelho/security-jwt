package com.rlti.security.usuario.application.api.response;

import com.rlti.security.usuario.domain.User;
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