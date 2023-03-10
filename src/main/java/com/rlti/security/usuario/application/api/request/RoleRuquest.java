package com.rlti.security.usuario.application.api.request;

import com.rlti.security.usuario.domain.ERole;

import javax.validation.constraints.NotNull;

public class RoleRuquest {
    @NotNull
    private ERole name;

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
