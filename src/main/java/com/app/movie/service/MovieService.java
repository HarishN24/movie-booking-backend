package com.app.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.movie.model.Movie;
import com.app.movie.repo.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).orElse(null);
	}

	public Movie updateMovie(Long id, Movie movie) {
		Movie existingMovie = movieRepository.findById(id).orElse(null);

		if (existingMovie != null) {
			existingMovie.setMovieName(movie.getMovieName());
			existingMovie.setGenre(movie.getGenre());
			existingMovie.setTicketPrice(movie.getTicketPrice());
			existingMovie.setShowTime(movie.getShowTime());
			existingMovie.setDescription(movie.getDescription());
			existingMovie.setDuration(movie.getDuration());
			existingMovie.setImageUrl(movie.getImageUrl());
			existingMovie.setLanguage(movie.getLanguage());

			return movieRepository.save(existingMovie);
		}

		return null;
	}

	public String deleteMovie(Long id) {
		movieRepository.deleteById(id);
		return "Movie Deleted Successfully";
	}
}
