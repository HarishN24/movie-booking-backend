package com.app.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.movie.model.Movie;
import com.app.movie.service.MovieService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}

	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		return movieService.updateMovie(id, movie);
	}

	@DeleteMapping("/{id}")
	public String deleteMovie(@PathVariable Long id) {
		return movieService.deleteMovie(id);
	}
}
