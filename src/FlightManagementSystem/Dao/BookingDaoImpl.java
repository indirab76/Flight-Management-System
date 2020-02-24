package FlightManagementSystem.Dao;

import java.math.BigInteger;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import FlightManagementSystem.util.DatabaseUtil;
import FlightManagementSystem.Dto.BookingDto;
import FlightManagementSystem.Dto.FlightDto;
import FlightManagementSystem.Dto.UserDto;
import FlightManagementSystem.Dto.PassengerDto;
import FlightManagementSystem.Dao.UserDaoImpl;
import FlightManagementSystem.Dao.FlightDaoImpl;

public class BookingDaoImpl implements BookingDao {

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	List<BookingDto> bookingList;
	BookingDto booking;
	UserDaoImpl userDao;
	FlightDaoImpl flightDao;
	PassengerDto passenger;
	Scanner sc;

	public BookingDaoImpl() throws SQLException {

		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
	}

	@Override
	public BookingDto addBooking(BookingDto booking1) throws SQLException {

		sc = new Scanner(System.in);
		String ch;

		pst = connection.prepareStatement("insert into booking values(sequence_booking.nextval,?,?,?,?,?,?)");

		pst.setLong(4, booking1.getUserId());
		pst.setDate(1, booking1.getBookingDate());
		pst.setDouble(2, booking1.getTicketCost());
		pst.setLong(5, booking1.getFlightNumber());
		pst.setInt(3, booking1.getNoOfPassengers());
		pst.setLong(6, booking1.getScheduleid());
		int res = pst.executeUpdate();

		if (res == 1) {
			System.out.println("Do you want to confirm your Booking? : yes\\no");
			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();

		} else
			return null;

		pst = connection.prepareStatement("select sequence_booking.currval from dual");
		rs = null;
		rs = pst.executeQuery();
		if (rs.next()) {
			booking1.setBookingId(rs.getLong(1));
		}
		return booking1;

	}

	public List<PassengerDto> addPassenger(List<PassengerDto> passengerlist) throws SQLException {
		int res = 0;
		String ch;
		sc = new Scanner(System.in);
		for (PassengerDto passenger1 : passengerlist) {

			// passenger=null;
			pst = connection.prepareStatement("insert into passenger values (sequence_passenger.nextval,?,?,?,?,?)");

			pst.setString(1, passenger1.getPassengerName());
			pst.setInt(2, passenger1.getPassengerAge());
			pst.setLong(3, passenger1.getPassengerUIN());
			pst.setDouble(4, passenger1.getLuggage());
			pst.setLong(5, passenger1.getBookingId());

			res = res + pst.executeUpdate();

		}
		System.out.println("result " + res);
		if (res >= 1) {
			System.out.println("Do you want to confirm your Booking? : yes\\no");
			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();
			return passengerlist;
		} else
			return null;
	}

	@Override
	public BookingDto viewBooking(long bookingId) throws SQLException {
		// TODO Auto-generated method stub
		pst = connection.prepareStatement("select *from booking where bookingId=?");
		pst.setLong(1, bookingId);
		rs = null;
		rs = pst.executeQuery();

		if (rs.next()) {
			booking = null;
			booking = new BookingDto();
			booking.setBookingId(rs.getLong(1));
			booking.setUserId(rs.getLong(5));
			booking.setBookingDate(rs.getDate(2));
			booking.setTicketCost(rs.getLong(3));
			booking.setFlightNumber(rs.getLong(6));
			booking.setNoOfPassengers(rs.getInt(4));
			booking.setScheduleid(rs.getLong(7));
			return booking;
		}
		return null;

	}

	@Override
	public List<BookingDto> viewBooking() throws SQLException {
		// TODO Auto-generated method stub
		bookingList = new ArrayList<BookingDto>();

		pst = connection.prepareStatement("select *from booking ");

		rs = null;
		rs = pst.executeQuery();

		while (rs.next()) {
			booking = null;
			booking = new BookingDto();
			booking.setBookingId(rs.getLong(1));
			booking.setUserId(rs.getLong(5));
			booking.setBookingDate(rs.getDate(2));
			booking.setTicketCost(rs.getLong(3));
			booking.setFlightNumber(rs.getLong(6));
			booking.setNoOfPassengers(rs.getInt(4));
			booking.setScheduleid(rs.getLong(7));

			bookingList.add(booking);
		}
		return bookingList;

	}

	public List<PassengerDto> viewPassenger(long bookingId) throws SQLException {
		// TODO Auto-generated method stub
		List<PassengerDto> passengerList = new ArrayList<PassengerDto>();

		pst = connection.prepareStatement("select *from passenger where bookingId=?");
		pst.setLong(1, bookingId);
		rs = null;
		rs = pst.executeQuery();

		while (rs.next()) {

			passenger = null;
			passenger = new PassengerDto();

			passenger.setPnrNumber(rs.getLong(1));
			passenger.setPassengerName(rs.getString(2));
			passenger.setPassengerAge(rs.getInt(3));
			passenger.setPassengerUIN(rs.getLong(4));
			passenger.setLuggage(rs.getDouble(5));
			passenger.setBookingId(rs.getLong(6));

			passengerList.add(passenger);

		}
		return passengerList;

	}

	@Override
	public void deleteBooking(long bookingId) throws SQLException {
		// TODO Auto-generated method stub
		pst = null;
		String ch;
		Scanner sc = new Scanner(System.in);
		pst = connection.prepareStatement("delete from booking where bookingId=?");
		pst.setLong(1, bookingId);

		int rst = pst.executeUpdate();

		if (rst == 1) {

			System.out.println("Are you sure you want to delete? : yes\\no");

			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();

			System.out.println("Flight with BookingId:" + bookingId + " has been deleted successfully.");

		}

		else
			System.out.println("Sorry! Some error occurred.");

	}
}
