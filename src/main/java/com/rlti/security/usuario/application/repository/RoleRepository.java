package com.rlti.security.usuario.application.repository;

import com.rlti.security.usuario.domain.ERole;
import com.rlti.security.usuario.domain.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(ERole name);
    Role findByRoleName(String name);
}
