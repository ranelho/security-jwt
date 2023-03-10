package com.rlti.security.autenticacao.api;


import com.rlti.security.autenticacao.api.response.TokenRefreshResponse;
import com.rlti.security.autenticacao.api.request.LoginRequest;
import com.rlti.security.autenticacao.api.request.TokenRefreshRequest;
import com.rlti.security.autenticacao.api.response.JwtResponse;
import com.rlti.security.autenticacao.api.response.MessageResponse;
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
