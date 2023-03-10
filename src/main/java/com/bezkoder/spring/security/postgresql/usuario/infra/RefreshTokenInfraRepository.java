package com.bezkoder.spring.security.postgresql.usuario.infra;

import com.bezkoder.spring.security.postgresql.usuario.application.repository.RefreshTokenRepository;
import com.bezkoder.spring.security.postgresql.usuario.domain.RefreshToken;

import java.util.Optional;

public class RefreshTokenInfraRepository implements RefreshTokenRepository {
    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return Optional.empty();
    }
}
