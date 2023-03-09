package com.bezkoder.spring.security.postgresql.autenticacao.api;

import com.bezkoder.spring.security.postgresql.autenticacao.api.service.AuthService;
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
        log.info("[inicio] Iniciando Metodo autenciacao em AutenticacaoController");
        JwtResponse jwtResponse = authService.autentica(loginRequest);
        log.info("[finaliza] Retornando Token para o cliente");
        return  jwtResponse;
    }
}
