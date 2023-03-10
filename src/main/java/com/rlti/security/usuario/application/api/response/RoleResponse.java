package com.rlti.security.usuario.application.api.response;

import com.rlti.security.usuario.domain.ERole;
import com.rlti.security.usuario.domain.Role;
import lombok.Value;

import java.util.UUID;

@Value
public class RoleResponse {
    private UUID id;
    private ERole name;

    public RoleResponse(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}
