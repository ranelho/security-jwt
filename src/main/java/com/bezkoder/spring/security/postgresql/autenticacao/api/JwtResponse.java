package com.bezkoder.spring.security.postgresql.autenticacao.api;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private UUID id;
	private String username;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, UUID userId, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = userId;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}



	public List<String> getRoles() {
		return roles;
	}
}
