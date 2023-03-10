package com.bezkoder.spring.security.postgresql.autenticacao.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.response.JwtResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthService {
    JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken);
}
