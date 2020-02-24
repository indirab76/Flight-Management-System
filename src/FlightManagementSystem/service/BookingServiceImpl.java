package FlightManagementSystem.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import FlightManagementSystem.Exception.BookingServiceException;
import FlightManagementSystem.Dto.*;
import FlightManagementSystem.Dao.*;

public class BookingServiceImpl implements BookingService {
	Scanner sc;
	BookingDto booking;
	BookingDto booking2;
	BookingDaoImpl bookingDao;
	PassengerDto passenger;
	FlightDaoImpl flightDao;
	ScheduledFlightDaoImpl scheduleDao;
	ScheduledFlightDto scheduleDto;
	UserDaoImpl userDao;
	List<PassengerDto> passengerList;
	List<PassengerDto> passengerList2;

	public BookingServiceImpl() throws SQLException {

		userDao = new UserDaoImpl();
		scheduleDao = new ScheduledFlightDaoImpl();
		flightDao = new FlightDaoImpl();
		bookingDao = new BookingDaoImpl();

	}

	// ***********************Method1_addbooking*************************
	@Override
	public void addBooking(long userId) throws BookingServiceException, SQLException, ParseException {

		booking = new BookingDto();
		passengerList = new ArrayList<PassengerDto>();
		passengerList2 = new ArrayList<PassengerDto>();
		scheduleDto = new ScheduledFlightDto();
		sc = new Scanner(System.in);

		System.out.println("Enter Schedule Id of the flight that you want to book:");
		long scheduleId = sc.nextLong();
		booking.setScheduleid(scheduleId);
		scheduleDto = scheduleDao.viewScheduledFlights(scheduleId);

		booking.setFlightNumber(scheduleDto.getFlight());

		System.out.println("\nEnter Number of Passengers:");
		int passengerNo=sc.nextInt();
		
		if(passengerNo>8)
			throw new BookingServiceException("Maximum limit of passenger booking reached.");
		else
			booking.setNoOfPassengers(passengerNo);
		booking.setUserId(userId);

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		booking.setBookingDate(sqlDate);

		booking.setTicketCost(scheduleDto.getTicketCost());

		if (!validateBooking(booking))
			throw new BookingServiceException("Error occured during booking.Please try again!");
		else {
			booking2 = new BookingDto();
			booking2 = bookingDao.addBooking(booking);
		}

		if (booking2 == null)

			System.out.println("Sorry! Some error occured.");

		else {

			for (int i = 0; i < booking2.getNoOfPassengers(); i++) {

				passenger = null;
				passenger = new PassengerDto();

				System.out.print("\n\nEnter Passenger" + i + " Name:");
				passenger.setPassengerName(sc.next());

				System.out.print("\nEnter Passenger" + i + " Age:");
				passenger.setPassengerAge(sc.nextInt());

				System.out.print("\nEnter Aadhar Number for Passenger" + i + " :");
				passenger.setPassengerUIN(sc.nextLong());

				System.out.print("\nEnter Luggage amount in kgs. for Passenger" + i + " :");
				passenger.setLuggage(sc.nextDouble());

				passenger.setBookingId(booking2.getBookingId());

				if (!validatePassenger(passenger))
					throw new BookingServiceException("Error occured during booking.Please try again!");
				else
					passengerList.add(passenger);

			}
			passengerList2 = bookingDao.addPassenger(passengerList);
			if (passengerList2 == null)
				System.out.println("Sorry!Some error occured.");
			else
				viewBooking(booking2.getBookingId());
		}
	}

	@Override
	public void viewBooking(long BookingId) throws SQLException {

		booking = new BookingDto();
		passenger = new PassengerDto();

		booking = bookingDao.viewBooking(BookingId);
		passengerList = new ArrayList<PassengerDto>();
		passengerList = bookingDao.viewPassenger(BookingId);

		System.out.println("Booking Details: ");
		System.out.println("\nBooking Id:" + BookingId);

		System.out.println("Booking Date:" + booking.getBookingDate());
		System.out.println("Ticket Cost: " + booking.getTicketCost());
		System.out.println("\n\nFlight Details: ");
		System.out.println("\nFlight Number: " + booking.getFlightNumber());
		System.out.println("Source: " + scheduleDao.viewScheduledFlights(booking.getScheduleid()).getSourceAirport());
		System.out.println(
				"Destination: " + scheduleDao.viewScheduledFlights(booking.getScheduleid()).getDestinationAirport());

		java.sql.Date d = scheduleDao.viewScheduledFlights(booking.getScheduleid()).getArrivalTime();
		Date d2 = new Date(d.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

		System.out.println("Arrival: " + sdf.format(d2));

		 d = scheduleDao.viewScheduledFlights(booking.getScheduleid()).getDepartureTime();
		 d2 = new Date(d.getTime());
	
		
		
		System.out
				.println("Departure: " +sdf.format(d2) );

		int i = 0;
		for (PassengerDto passenger1 : passengerList) {
			i++;
			System.out.println("\n\n\n");

			System.out.println("Passenger" + i + " Pnr Number: " + passenger1.getPnrNumber());

			System.out.println("Passenger" + i + " Name: " + passenger1.getPassengerName());

			System.out.println("Passenger" + i + " Age: " + passenger1.getPassengerAge());

			System.out.println("Aadhar Number for Passenger" + i + " : " + passenger1.getPassengerUIN());

			System.out.println("Luggage amount in kgs. for Passenger" + i + " : " + passenger1.getLuggage());

		}
	}

	public void viewBooking() throws SQLException {

		List<BookingDto> bookingList = new ArrayList<BookingDto>();
		bookingList = bookingDao.viewBooking();

		System.out.println("BookingId  UserId  BookingDate  TicketCost  FlightNumber  NoOfPassengers");

		for (BookingDto booking : bookingList) {
			System.out.println(booking.getBookingId() + "  " + booking.getUserId() + "  " + booking.getBookingDate()
					+ "  " + booking.getTicketCost() + "  " + booking.getFlightNumber() + "  "
					+ booking.getNoOfPassengers());

		}
	}

	@Override
	public void deleteBooking(long bookingId) throws SQLException {

		bookingDao.deleteBooking(bookingId);
	}

	@Override
	public boolean validateBooking(BookingDto booking) throws BookingServiceException {

		if (booking.getScheduleid() == 0)
			throw new BookingServiceException("Please enter ScheduleId !");
		else
			return true;
	}

	@Override
	public boolean validatePassenger(PassengerDto passenger) throws BookingServiceException {

		if (passenger.getPassengerName() == null || passenger.getPassengerAge() == 0 || passenger.getLuggage() == 0
				|| Long.toString(passenger.getPassengerUIN()).length() == 12) {
			throw new BookingServiceException("Please enter all the field!");
		} else
			return true;
	}

}
