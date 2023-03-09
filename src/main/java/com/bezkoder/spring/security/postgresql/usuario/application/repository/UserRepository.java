package com.bezkoder.spring.security.postgresql.usuario.application.repository;

import com.bezkoder.spring.security.postgresql.usuario.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsuario(String username);
    User salva(User usuario);
}
