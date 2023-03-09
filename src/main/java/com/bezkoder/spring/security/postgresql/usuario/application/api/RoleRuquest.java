package com.bezkoder.spring.security.postgresql.usuario.application.api;

import com.bezkoder.spring.security.postgresql.usuario.domain.ERole;

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
