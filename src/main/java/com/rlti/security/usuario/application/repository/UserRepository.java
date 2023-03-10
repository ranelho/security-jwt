package com.rlti.security.usuario.application.repository;

import com.rlti.security.usuario.domain.Role;
import com.rlti.security.usuario.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsuario(String username);
    User salva(User usuario);
    Role salvaRole(Role role);

    List<Object> findById(Long userId);
}
