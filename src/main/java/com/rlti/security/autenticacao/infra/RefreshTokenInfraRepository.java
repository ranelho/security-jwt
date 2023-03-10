package com.rlti.security.autenticacao.infra;

import com.rlti.security.autenticacao.application.repository.RefreshTokenRepository;
import com.rlti.security.autenticacao.domain.RefreshToken;

import java.util.Optional;

public class RefreshTokenInfraRepository implements RefreshTokenRepository {
    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return Optional.empty();
    }
}
