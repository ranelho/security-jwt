package com.rlti.security.autenticacao.application.service;

import com.rlti.security.autenticacao.application.api.request.TokenRefreshRequest;
import com.rlti.security.autenticacao.application.api.response.JwtResponse;
import com.rlti.security.autenticacao.application.api.response.MessageResponse;
import com.rlti.security.autenticacao.application.api.response.TokenRefreshResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthService {
    JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken);
    TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request);
    MessageResponse logoutUser();
}
