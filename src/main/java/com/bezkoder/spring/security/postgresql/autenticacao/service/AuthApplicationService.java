package com.bezkoder.spring.security.postgresql.autenticacao.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.request.TokenRefreshRequest;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.JwtResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.MessageResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.TokenRefreshResponse;
import com.bezkoder.spring.security.postgresql.security.exception.TokenRefreshException;
import com.bezkoder.spring.security.postgresql.security.jwt.JwtUtils;
import com.bezkoder.spring.security.postgresql.security.services.RefreshTokenService;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import com.bezkoder.spring.security.postgresql.usuario.domain.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class AuthApplicationService implements AuthService {

    AuthenticationManager authenticationManager;
    RefreshTokenService refreshTokenService;
    JwtUtils jwtUtils;

    @Override
    public JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken) {
        log.info("[inicio] AuthApplicationService - autentica");
        Authentication authentication = authenticationManager.authenticate(userPassToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        log.info("[finaliza] AuthApplicationService - autentica");
        return new JwtResponse(jwt,userDetails, refreshToken.getToken());
    }

    @Override
    public TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return new TokenRefreshResponse(token, requestRefreshToken);
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
    }

    @Override
    public MessageResponse logoutUser() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UUID userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);
        return new MessageResponse("Log out successful!");
    }
}
