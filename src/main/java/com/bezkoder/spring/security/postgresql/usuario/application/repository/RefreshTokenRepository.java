package com.bezkoder.spring.security.postgresql.usuario.application.repository;

import com.bezkoder.spring.security.postgresql.usuario.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    Optional<RefreshToken> findByToken(String token);
}
