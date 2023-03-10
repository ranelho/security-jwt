package com.bezkoder.spring.security.postgresql.autenticacao.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.response.JwtResponse;
import com.bezkoder.spring.security.postgresql.security.jwt.JwtUtils;
import com.bezkoder.spring.security.postgresql.security.services.RefreshTokenService;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import com.bezkoder.spring.security.postgresql.usuario.domain.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
}
