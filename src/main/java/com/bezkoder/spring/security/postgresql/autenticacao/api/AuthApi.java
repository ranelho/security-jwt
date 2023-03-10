package com.bezkoder.spring.security.postgresql.autenticacao.api;


import com.bezkoder.spring.security.postgresql.autenticacao.api.request.LoginRequest;
import com.bezkoder.spring.security.postgresql.autenticacao.api.request.TokenRefreshRequest;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.JwtResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.MessageResponse;
import com.bezkoder.spring.security.postgresql.autenticacao.api.response.TokenRefreshResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public interface AuthApi {

    @PostMapping("/signin")
    JwtResponse autentica(@RequestBody @Valid LoginRequest loginRequest) throws AuthenticationException;

    @PostMapping("/refreshToken")
    TokenRefreshResponse reativaAutenticacao(@Valid @RequestBody TokenRefreshRequest request) ;

    @PostMapping("/signout")
    MessageResponse logoutUser();
}
