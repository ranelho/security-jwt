package com.bezkoder.spring.security.postgresql.autenticacao.api.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.JwtResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.LoginRequest;

public interface AuthService {
    JwtResponse autentica(LoginRequest loginRequest);
}
