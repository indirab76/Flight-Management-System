package FlightManagementSystem.service;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import FlightManagementSystem.Dto.BookingDto;
import FlightManagementSystem.Dto.PassengerDto;
import FlightManagementSystem.Exception.BookingServiceException;
import FlightManagementSystem.Exception.UserServiceException;

public interface BookingService {
	


	void viewBooking(long BookingId) throws SQLException;

	void deleteBooking(long bookingId) throws SQLException;

	boolean validateBooking(BookingDto booking) throws BookingServiceException;

	boolean validatePassenger(PassengerDto passenger) throws BookingServiceException;

	void addBooking(long userId) throws BookingServiceException, SQLException, ParseException;
	

	
}
