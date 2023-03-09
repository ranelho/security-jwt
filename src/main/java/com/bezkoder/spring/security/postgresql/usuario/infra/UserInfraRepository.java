package com.bezkoder.spring.security.postgresql.usuario.infra;

import com.bezkoder.spring.security.postgresql.usuario.application.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.usuario.domain.Role;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@ResponseStatus
@Log4j2
@RequiredArgsConstructor
@Repository
public class UserInfraRepository implements UserRepository {

    private final UserSpringDataJPARepository userSpringDataJPARepository;
    private final RoleSpingDataJPARepository roleSpingDataJPARepository;

    @Override
    public User salva(User usuario) {
        log.info("[inicia] UserInfraRepository - salva");
        userSpringDataJPARepository.save(usuario);
        log.info("[finaliza] UserInfraRepository - salva");
        return usuario;
    }

    @Override
    public Role salvaRole(Role role) {
        log.info("[inicia] UserInfraRepository - salvaRole");
        roleSpingDataJPARepository.save(role);
        log.info("[finaliza] UserInfraRepository - salvaRole");
        return role;
    }

    @Override
    public Optional<User> findByUsuario(String usuario) {
        log.info("[inicia] UserInfraRepository - findByUsuario");
        Optional<User> user = userSpringDataJPARepository.findByUsername(usuario);
        log.info("[finaliza] UserInfraRepository - findByUsuario");
        return user;
    }
}