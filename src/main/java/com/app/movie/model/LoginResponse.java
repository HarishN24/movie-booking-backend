package com.app.movie.model;

public class LoginResponse {

	private String token;
	private String name;
	private String email;
	private String role;

	public LoginResponse(String token, String name, String email,String role) {
		
		this.token = token;
		this.name = name;
		this.email=email;
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}
}
