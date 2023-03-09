package com.bezkoder.spring.security.postgresql.autenticacao.api.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.JwtResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthService {
    JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken);
}
