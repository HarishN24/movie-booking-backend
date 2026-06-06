package com.app.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.movie.model.LoginResponse;
import com.app.movie.model.User;
import com.app.movie.security.JwtUtil;
import com.app.movie.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {

		return userService.registerUser(user);
	}

	@PostMapping("/login")
	public LoginResponse loginUser(@RequestBody User user) {

		User dbUser = userService.loginUser(user.getEmail(), user.getPassword());

		if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {

			return null;
		}
		String token = jwtUtil.generateToken(dbUser.getEmail());

		return new LoginResponse(token, dbUser.getName(), dbUser.getEmail(), dbUser.getRole().name());

	}

}
