package com.bezkoder.spring.security.postgresql.usuario.application.repository;

import com.bezkoder.spring.security.postgresql.usuario.domain.ERole;
import com.bezkoder.spring.security.postgresql.usuario.domain.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(ERole name);
    Role findByRoleName(String name);
}
