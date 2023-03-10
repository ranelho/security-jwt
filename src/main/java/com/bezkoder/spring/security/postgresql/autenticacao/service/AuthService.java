package com.bezkoder.spring.security.postgresql.autenticacao.service;

import com.bezkoder.spring.security.postgresql.autenticacao.api.request.TokenRefreshRequest;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.JwtResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.MessageResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.TokenRefreshResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthService {
    JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken);
    TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request);
    MessageResponse logoutUser();
}
