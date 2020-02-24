package FlightManagementSystem.Dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import FlightManagementSystem.Dto.BookingDto;
import FlightManagementSystem.Dto.PassengerDto;
public interface BookingDao {
	
	

	
	public BookingDto viewBooking(long bookingId) throws SQLException;
	public void deleteBooking(long bookingId) throws SQLException;
	BookingDto addBooking(BookingDto booking1) throws SQLException;
	List<BookingDto> viewBooking() throws SQLException;
	List<PassengerDto> addPassenger(List<PassengerDto> passengerlist) throws SQLException;
	List<PassengerDto> viewPassenger(long bookingId) throws SQLException;
}
