package com.bezkoder.spring.security.postgresql.autenticacao.api;

import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

@Value
public class LoginRequest {
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	public UsernamePasswordAuthenticationToken getUserPassToken() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}
}
