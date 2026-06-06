package com.app.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.movie.model.User;
import com.app.movie.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {

		return userRepository.save(user);
	}

	public User loginUser(String email, String password) {

		User user = userRepository.findByEmail(email);

		if (user != null && user.getPassword().equals(password)) {

			return user;
		}

		return null;
	}
}
