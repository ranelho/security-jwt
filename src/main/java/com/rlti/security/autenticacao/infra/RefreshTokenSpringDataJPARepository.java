package com.rlti.security.autenticacao.infra;

import com.rlti.security.autenticacao.domain.RefreshToken;
import com.rlti.security.usuario.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenSpringDataJPARepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
