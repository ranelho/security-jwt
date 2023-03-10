package com.rlti.security.autenticacao.service;

import com.rlti.security.autenticacao.api.request.TokenRefreshRequest;
import com.rlti.security.autenticacao.api.response.JwtResponse;
import com.rlti.security.autenticacao.api.response.MessageResponse;
import com.rlti.security.autenticacao.api.response.TokenRefreshResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthService {
    JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken);
    TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request);
    MessageResponse logoutUser();
}
