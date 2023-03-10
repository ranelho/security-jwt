package com.rlti.security.usuario.infra;

import com.rlti.security.usuario.application.repository.RefreshTokenRepository;
import com.rlti.security.usuario.domain.RefreshToken;

import java.util.Optional;

public class RefreshTokenInfraRepository implements RefreshTokenRepository {
    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return Optional.empty();
    }
}
