package com.app.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
