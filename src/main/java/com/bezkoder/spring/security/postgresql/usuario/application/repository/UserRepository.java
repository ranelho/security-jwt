package com.bezkoder.spring.security.postgresql.usuario.application.repository;

import com.bezkoder.spring.security.postgresql.usuario.domain.Role;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsuario(String username);
    User salva(User usuario);
    Role salvaRole(Role role);

    List<Object> findById(Long userId);
}
