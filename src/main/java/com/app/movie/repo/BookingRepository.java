package com.app.movie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.movie.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	Booking findBySeatNumber(String seatNumber);

	Booking findByMovieNameAndShowTimeAndSeatNumber(String movieName, String showTime, String seatNumber);

	List<Booking> findByEmail(String email);

	List<Booking> findByMovieNameAndShowTime(String movieName, String showTime);

}
