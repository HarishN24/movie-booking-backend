package com.app.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.movie.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
