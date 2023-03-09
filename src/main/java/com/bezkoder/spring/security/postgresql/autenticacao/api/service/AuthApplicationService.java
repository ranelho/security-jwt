package com.bezkoder.spring.security.postgresql.autenticacao.api.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.JwtResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.LoginRequest;
import com.bezkoder.spring.security.postgresql.security.jwt.JwtUtils;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import com.bezkoder.spring.security.postgresql.usuario.application.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class AuthApplicationService implements AuthService {

    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;

    @Override
    public JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken) {
        log.info("[inicio] AuthApplicationService - autentica");
        Authentication authentication = authenticationManager.authenticate(userPassToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        log.info("[finaliza] AuthApplicationService - autentica");
        return new JwtResponse(jwt,userDetails);
    }
}
