package com.rlti.security.usuario.application.service;

import com.rlti.security.usuario.application.api.request.RoleRuquest;
import com.rlti.security.usuario.application.api.request.UserRequest;
import com.rlti.security.usuario.application.api.response.RoleResponse;
import com.rlti.security.usuario.application.api.response.UserResponse;
import com.rlti.security.usuario.domain.User;

public interface UserService {
    UserResponse novoUsuario(UserRequest usuarioRequest);
    User findByUsuario(String usuario);
    RoleResponse novaRole(RoleRuquest roleRuquest);
}
