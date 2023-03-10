package com.rlti.security.usuario.infra;

import com.rlti.security.usuario.domain.ERole;
import com.rlti.security.usuario.domain.Role;
import com.rlti.security.usuario.application.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Log4j2
public class RoleInfraRepository implements RoleRepository {
    private final RoleSpingDataJPARepository roleSpingDataJPARepository;

    @Override
    public Optional<Role> findByName(ERole name) {
        log.info("[inicia] RoleInfraRepository - findByRole");
        Optional<Role> roleOptional = roleSpingDataJPARepository.findByName(name);
        log.info("[finaliza] RoleInfraRepository - findByRole");
        return  roleOptional;
    }

    @Override
    public Role findByRoleName(String name) {
        log.info("[inicia] RoleInfraRepository - findByRole");
        Optional<Role> roleOptional = roleSpingDataJPARepository.findByRoleName(name);
        Role role = roleOptional.orElseThrow( () -> new UsernameNotFoundException("Regra Inexistente! "));
        log.info("[finaliza] RoleInfraRepository - findByRole");
        return  role;
    }
}
