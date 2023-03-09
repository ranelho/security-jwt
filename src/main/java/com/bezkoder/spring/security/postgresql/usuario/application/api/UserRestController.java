package com.bezkoder.spring.security.postgresql.usuario.application.api;

import com.bezkoder.spring.security.postgresql.usuario.application.service.UserService;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserRestController implements UserApi {

    private final UserService userService;

    @Override
    public UserResponse postUsuario(UserRequest userRequest) {
        log.info("[inicia] UsuarioRestController - postUsuario");
        UserResponse usuario = userService.novoUsuario(userRequest);
        log.info("[finaliza] UsuarioRestController - postUsuario");
        return usuario;
    }

    @Override
    public RoleResponse postRole(RoleRuquest roleRuquest) {
        log.info("[inicia] UsuarioRestController - postRole");
        RoleResponse roleResponse = userService.novaRole(roleRuquest);
        log.info("[finaliza] UsuarioRestController - postRole");
        return roleResponse;

    }

    @Override
    public UserResponse getByUsuario(String usuario) {
        log.info("[inicia] UsuarioRestController - getByUsuario");
        User user = userService.findByUsuario(usuario);
        log.info("[finaliza] UsuarioRestController - getByUsuario");
        return new UserResponse(user);
    }
}
