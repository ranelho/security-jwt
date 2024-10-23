package com.rlti.security.autenticacao.application.api;

import com.rlti.security.autenticacao.application.api.request.LoginRequest;
import com.rlti.security.autenticacao.application.api.response.TokenRefreshResponse;
import com.rlti.security.autenticacao.application.api.request.TokenRefreshRequest;
import com.rlti.security.autenticacao.application.api.response.JwtResponse;
import com.rlti.security.autenticacao.application.api.response.MessageResponse;
import com.rlti.security.autenticacao.application.service.AuthService;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@Log4j2
public class AuthRestController implements AuthApi {
    private final AuthService authService;

    @Override
    public JwtResponse autentica(LoginRequest loginRequest) throws AuthenticationException {
        log.info("[inicio] AuthRestController - autentica");
        JwtResponse jwtResponse = authService.autentica(loginRequest.getUserPassToken());
        log.info("[finaliza] AuthRestController - autentica");
        return  jwtResponse;
    }

    @Override
    public TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request) {
        log.info("[inicio] AuthRestController - reativaAutenticacao");
        TokenRefreshResponse refreshResponse = authService.reativaAutenticacao(request);
        log.info("[finaliza] AuthRestController - reativaAutenticacao");
        return refreshResponse;
    }

    @Override
    public MessageResponse logoutUser() {
        log.info("[inicio] AuthRestController - logoutUser");
        MessageResponse messageResponse = authService.logoutUser();
        log.info("[finaliza] AuthRestController - logoutUser");
        return messageResponse;
    }

    @Override
    public Boolean validateToken(String token) {
        return authService.validateToken(token);
    }
}
