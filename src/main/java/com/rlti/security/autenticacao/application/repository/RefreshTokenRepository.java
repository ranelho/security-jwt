package com.rlti.security.autenticacao.application.repository;

import com.rlti.security.autenticacao.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    Optional<RefreshToken> findByToken(String token);
}
