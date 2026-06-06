package com.app.movie.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.movie.model.Booking;
import com.app.movie.repo.BookingRepository;
import com.app.movie.service.BookingService;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingRepository bookingRepository;

	// Book Ticket
	@PostMapping
	public String bookTicket(@RequestBody Booking booking) {

		return bookingService.bookTicket(booking);
	}

	// ADMIN View All Bookings
	@GetMapping
	public List<Booking> getAllBookings() {

		return bookingService.getAllBookings();
	}

	@GetMapping("/seats")
	public List<String> getBookedSeats(

			@RequestParam String movieName, @RequestParam String showTime) {

		return bookingRepository.findByMovieNameAndShowTime(movieName, showTime).stream().map(Booking::getSeatNumber)
				.filter(Objects::nonNull).flatMap(seat -> Arrays.stream(seat.split(","))).collect(Collectors.toList());
	}

	@GetMapping("/user/{email}")
	public List<Booking> getUserBookings(@PathVariable String email) {

		return bookingRepository.findByEmail(email);
	}

	@DeleteMapping("/{id}")
	public String cancelBooking(@PathVariable Long id) {

		bookingRepository.deleteById(id);

		return "Booking Cancelled";
	}
}
