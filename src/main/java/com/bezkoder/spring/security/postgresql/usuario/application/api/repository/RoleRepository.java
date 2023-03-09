package com.bezkoder.spring.security.postgresql.usuario.application.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.security.postgresql.usuario.domain.ERole;
import com.bezkoder.spring.security.postgresql.usuario.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
