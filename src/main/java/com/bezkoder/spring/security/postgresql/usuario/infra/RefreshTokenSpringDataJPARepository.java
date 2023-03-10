package com.bezkoder.spring.security.postgresql.usuario.infra;

import com.bezkoder.spring.security.postgresql.usuario.domain.RefreshToken;
import com.bezkoder.spring.security.postgresql.usuario.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenSpringDataJPARepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
