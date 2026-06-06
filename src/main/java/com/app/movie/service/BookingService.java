package com.app.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.movie.model.Booking;
import com.app.movie.repo.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public String bookTicket(Booking booking) {
		Booking existingSeat = bookingRepository.findByMovieNameAndShowTimeAndSeatNumber(booking.getMovieName(),
				booking.getShowTime(), booking.getSeatNumber());

		if (existingSeat != null) {

			return "Seat Already Booked";
		}

		bookingRepository.save(booking);

		return "Ticket Booked Successfully";
	}

	public List<Booking> getAllBookings() {

		return bookingRepository.findAll();
	}
}
