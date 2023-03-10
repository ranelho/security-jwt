package com.bezkoder.spring.security.postgresql.usuario.application.service;

import com.bezkoder.spring.security.postgresql.usuario.application.api.response.RoleResponse;
import com.bezkoder.spring.security.postgresql.usuario.application.api.request.RoleRuquest;
import com.bezkoder.spring.security.postgresql.usuario.application.api.request.UserRequest;
import com.bezkoder.spring.security.postgresql.usuario.application.api.response.UserResponse;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;

public interface UserService {
    UserResponse novoUsuario(UserRequest usuarioRequest);
    User findByUsuario(String usuario);
    RoleResponse novaRole(RoleRuquest roleRuquest);
}
