package com.bezkoder.spring.security.postgresql.usuario.application.service;

import com.bezkoder.spring.security.postgresql.usuario.application.api.UserRequest;
import com.bezkoder.spring.security.postgresql.usuario.application.api.UserResponse;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;

public interface UserService {
    UserResponse novoUsuario(UserRequest usuarioRequest);
    User findByUsuario(String usuario);
}
