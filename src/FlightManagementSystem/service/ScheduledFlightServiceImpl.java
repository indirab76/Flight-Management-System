package FlightManagementSystem.service;

import java.sql.Date;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import FlightManagementSystem.Dao.*;
import FlightManagementSystem.Dto.*;
import FlightManagementSystem.Exception.EmailValidator;
import FlightManagementSystem.Exception.ScheduledFlightException;
import FlightManagementSystem.Exception.UserServiceException;

public class ScheduledFlightServiceImpl implements ScheduledFlightService {

	ScheduledFlightDto scheduleDto = new ScheduledFlightDto();
	ScheduledFlightDaoImpl scheduleDao = null;
	List<ScheduledFlightDto> scheduleList;
	// FlightDao flightDao;
	Scanner sc = new Scanner(System.in);

	public ScheduledFlightServiceImpl() throws SQLException {
		scheduleDao = new ScheduledFlightDaoImpl();
	}

	@Override
	public void scheduleFlight() throws ParseException, ScheduledFlightException, SQLException {

		System.out.println("Enter details for new schedule:");

		System.out.println("\nEnter Flight Number: ");
		scheduleDto.setFlight(sc.nextLong());
		System.out.println("\nEnter Source Airport Code: ");
		scheduleDto.setSourceAirport(sc.next());
		System.out.println("\nEnter Destination Airport Code: ");
		scheduleDto.setDestinationAirport(sc.next());
		System.out.println("\nEnter Boarding Date (DD-MM-YYYY): ");
		java.sql.Date date1=new Date(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()).getTime());
		scheduleDto.setBoardingDate(date1 );
		System.out.println("\nEnter Arrival Time: ");
		date1=new Date(new SimpleDateFormat("hh:mm").parse(sc.next()).getTime());
		scheduleDto.setArrivalTime(date1);
		System.out.println("\nEnter Departure Time: ");
		date1=new Date(new SimpleDateFormat("hh:mm").parse(sc.next()).getTime());
		scheduleDto.setDepartureTime(date1);
		System.out.println("\nEnter Available Seats: ");
		scheduleDto.setAvailableSeats(sc.nextInt());
		System.out.println("\nEnter Ticket Cost: ");
		scheduleDto.setTicketCost(sc.nextFloat());

		if (!validateSchedule(scheduleDto))
			throw new ScheduledFlightException("Error occured during entering schedule! Please try again.");
		else {
			scheduleDto = scheduleDao.scheduleFlight(scheduleDto);
			if (scheduleDto != null)
				viewScheduleFlight(scheduleDto);
		}
		return ;

	}

	@Override
	public void viewScheduleFlight(ScheduledFlightDto scheduleDto) {

		System.out.println(
				"ScheduleId   FlightNumber   Boarding Date   SourceAirport_code   DestinationAirport_code   ArrivalTime   DepartureTime   TicketCost   AvailableSeats\n");

		System.out.print(scheduleDto.getScheduleId() + "         ");
		System.out.print(scheduleDto.getFlight() + "          ");
		System.out.print(scheduleDto.getBoardingDate() + "           ");
		System.out.print(scheduleDto.getSourceAirport() + "           ");
		System.out.print(scheduleDto.getDestinationAirport() + "           ");
		System.out.print(scheduleDto.getArrivalTime() + "             ");
		System.out.print(scheduleDto.getDepartureTime() + "              ");
		System.out.print(scheduleDto.getTicketCost() + "                ");
		System.out.print(scheduleDto.getAvailableSeats() + "                ");

	}

	public boolean validateSchedule(ScheduledFlightDto scheduleDto) throws ScheduledFlightException {

		if (scheduleDto.getFlight() == 0 || scheduleDto.getBoardingDate() == null
				|| scheduleDto.getSourceAirport() == null || scheduleDto.getDestinationAirport() == null
				|| scheduleDto.getArrivalTime() == null || scheduleDto.getDepartureTime() == null
				|| scheduleDto.getTicketCost() == 0 || scheduleDto.getAvailableSeats() == 0) {

			throw new ScheduledFlightException("Please enter all the fields correctly!");
		} else
			return true;
	}

	@Override
	public void viewScheduleFlight() throws SQLException {

		scheduleList = new ArrayList<ScheduledFlightDto>();
		scheduleList = scheduleDao.viewScheduledFlight();

		System.out.println(
				"ScheduleId   FlightNumber   Boarding Date   SourceAirport_code   DestinationAirport_code   ArrivalTime   DepartureTime   TicketCost   AvailableSeats\n");

		for (ScheduledFlightDto scheduleflight : scheduleList) {

			System.out.print(scheduleflight.getScheduleId() + "         ");
			System.out.print(scheduleflight.getFlight() + "          ");
			System.out.print(scheduleflight.getBoardingDate() + "           ");
			System.out.print(scheduleflight.getSourceAirport() + "           ");
			System.out.print(scheduleflight.getDestinationAirport() + "           ");
			System.out.print(scheduleflight.getArrivalTime() + "             ");
			System.out.print(scheduleflight.getDepartureTime() + "              ");
			System.out.print(scheduleflight.getTicketCost() + "                ");
			System.out.print(scheduleflight.getAvailableSeats() + "                ");

			System.out.println();
		}
	}

	@Override
	public void searchFlight() throws SQLException, ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-YYYY");

		System.out.println("Enter your Source location: ");
		String source = sc.next();
		System.out.println("Enter your Destination location: ");
		String destination = sc.next();
		System.out.println("Enter your intended Boarding date: ");
		java.sql.Date date1=new Date(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()).getTime());
		scheduleDto.setBoardingDate(date1 );
		

		scheduleList = new ArrayList<ScheduledFlightDto>();
		scheduleList = scheduleDao.viewScheduledFlights(source, destination, date1);

		System.out.println(
				"ScheduleId   FlightNumber   Boarding Date   SourceAirport_code   DestinationAirport_code   ArrivalTime   DepartureTime   TicketCost   AvailableSeats\n");

		for (ScheduledFlightDto scheduleflight : scheduleList) {

			System.out.print(scheduleflight.getScheduleId() + "         ");
			System.out.print(scheduleflight.getFlight() + "          ");
			System.out.print(scheduleflight.getBoardingDate() + "           ");
			System.out.print(scheduleflight.getSourceAirport() + "           ");
			System.out.print(scheduleflight.getDestinationAirport() + "           ");
			System.out.print(scheduleflight.getArrivalTime() + "             ");
			System.out.print(scheduleflight.getDepartureTime() + "              ");
			System.out.print(scheduleflight.getTicketCost() + "                ");
			System.out.print(scheduleflight.getAvailableSeats() + "                ");

			System.out.println();
		}

	}

	@Override
	public void deleteScheduleFlight() throws SQLException {

		System.out.println("Enter Schedule Id that you want to delete: ");
		scheduleDao.deleteScheduledFlight(sc.nextLong());

	}

	@Override
	public void modifyScheduleFlight() throws ParseException, SQLException {

		System.out.println("Enter the Schedule Id of the schedule that you want to modify: ");
		long scheduleId = sc.nextLong();
		scheduleDto = scheduleDao.viewScheduledFlights(scheduleId);

		System.out.println(
				"Which field do you want to modify: 1.Flight Number\n2.Source Airport_Code\n3.Destination Airport_Code"
						+ "\n4.Boarding Date (DD-MM-YYYY)\n5.Arrival Time\n6.Departure Time\n7.Available Seats\n8.Ticket Cost");
		String ch = sc.next();
		switch (ch) {
		case "Flight Number":
			System.out.print("Enter Flight Number: ");
			scheduleDto.setFlight(sc.nextLong());
			break;

		case "Source Airport_Code":
			System.out.println("Enter Source Airport_Code: ");
			scheduleDto.setSourceAirport(sc.next());
			break;

		case "Destination Airport_Code":
			System.out.println("Enter Destination Airport_Code: ");
			scheduleDto.setDestinationAirport(sc.next());
			break;

		case "Boarding Date (DD-MM-YYYY)":
			System.out.println("Enter Boarding Date (DD-MM-YYYY): ");
			scheduleDto.setBoardingDate((Date) new SimpleDateFormat("DD-MM-YYYY").parse(sc.next()));
			break;

		case "Arrival Time":
			System.out.println("Enter Arrival Time: ");
			scheduleDto.setBoardingDate((Date) new SimpleDateFormat("HH24:MM").parse(sc.next()));
			break;

		case "Departure Time":
			System.out.println("Enter Departure Time:");
			scheduleDto.setBoardingDate((Date) new SimpleDateFormat("HH24:MM").parse(sc.next()));
			break;

		case "Available Seat":
			System.out.println("Enter Available Seats: ");
			scheduleDto.setAvailableSeats(sc.nextInt());
			break;
		case "Ticket Cost":
			System.out.println("Enter Ticket Cost: ");
			scheduleDto.setTicketCost(sc.nextFloat());
			break;
		}
	}
}
