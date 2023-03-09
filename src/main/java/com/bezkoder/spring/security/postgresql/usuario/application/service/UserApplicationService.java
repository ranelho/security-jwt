package com.bezkoder.spring.security.postgresql.usuario.application.service;

import com.bezkoder.spring.security.postgresql.security.services.UserDetailsApplicationService;
import com.bezkoder.spring.security.postgresql.usuario.application.api.UserRequest;
import com.bezkoder.spring.security.postgresql.usuario.application.api.UserResponse;
import com.bezkoder.spring.security.postgresql.usuario.application.repository.RoleRepository;
import com.bezkoder.spring.security.postgresql.usuario.application.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.usuario.domain.ERole;
import com.bezkoder.spring.security.postgresql.usuario.domain.Role;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;
import com.bezkoder.spring.security.postgresql.handler.APIException;
import com.bezkoder.spring.security.postgresql.usuario.domain.ValidaRole;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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
    public User findByUsuario(String usuario) {
        log.info("[inicia] UsuarioApplicationService - findByUsuario");
        User response = usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.info("[finaliza] UsuarioApplicationService - findByUsuario");
        return (response);
    }
}