package com.rlti.security.usuario.application.repository;

import com.rlti.security.usuario.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    Optional<RefreshToken> findByToken(String token);
}
