package com.rlti.security.usuario.application.service;

import com.rlti.security.usuario.application.api.request.UserRequest;
import com.rlti.security.usuario.application.api.response.RoleResponse;
import com.rlti.security.usuario.application.api.response.UserResponse;
import com.rlti.security.usuario.application.repository.UserRepository;
import com.rlti.security.usuario.domain.Role;
import com.rlti.security.usuario.domain.User;
import com.rlti.security.handler.APIException;
import com.rlti.security.security.services.UserDetailsApplicationService;
import com.rlti.security.usuario.application.api.request.RoleRuquest;
import com.rlti.security.usuario.application.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class UserApplicationService implements UserService {

    private final UserRepository usuarioRepository;
    private final UserDetailsApplicationService userDetailsApplicationService;
    private final RoleRepository roleRepository;

    @Override
    public UserResponse novoUsuario(UserRequest usuarioRequest) {
        log.info("[inicia] UsuarioApplicationService - novoUsuario");
        Role role = roleRepository.findByRoleName(usuarioRequest.getName());
        User usuario = usuarioRepository.salva(new User(usuarioRequest, role));
        log.info("[finaliza] UsuarioApplicationService - novoUsuario");
        return new UserResponse(usuario);
    }

    @Override
    public RoleResponse novaRole(RoleRuquest roleRuquest) {
        log.info("[inicia] UsuarioApplicationService - novaRole");
        if(roleRepository.findByName(roleRuquest.getName()).isPresent()) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Role já cadastrada!");
        }else {
            Role role = usuarioRepository.salvaRole(new Role(roleRuquest));
            log.info("[finaliza] UsuarioApplicationService - novaRole");
            return new RoleResponse(role);
        }
    }

    @Override
    public User findByUsuario(String usuario) {
        log.info("[inicia] UsuarioApplicationService - findByUsuario");
        User response = usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.info("[finaliza] UsuarioApplicationService - findByUsuario");
        return (response);
    }
}