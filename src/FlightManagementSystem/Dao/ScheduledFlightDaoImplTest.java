package FlightManagementSystem.Dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FlightManagementSystem.Dto.ScheduledFlightDto;

public class ScheduledFlightDaoImplTest {
 ScheduledFlightDaoImpl dao;
 ScheduledFlightDto dto;
	@Before
	public void setUp() throws Exception {
		dao=new ScheduledFlightDaoImpl();
		dto=new ScheduledFlightDto();
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
		dto=null;
	}

	@Test
	public void testScheduleFlight() throws ParseException, SQLException {
		
		dto.setSourceAirport("BANGLR");
		dto.setDestinationAirport("DEL");
		java.sql.Date date1=new Date(new SimpleDateFormat("dd-MM-yyyy").parse("28-02-2020").getTime());
		dto.setBoardingDate(date1 );
		date1=new Date(new SimpleDateFormat("hh:mm").parse("12:30").getTime());
		dto.setArrivalTime(date1);
		date1=new Date(new SimpleDateFormat("hh:mm").parse("16:30").getTime());
		dto.setDepartureTime(date1);
		dto.setAvailableSeats(100);
		dto.setFlight(40007);
		dto.setTicketCost(7800);
		
		assertNotNull(dao.scheduleFlight(dto));
		
	}

	@Test
	public void testViewScheduledFlightsStringStringDate() throws ParseException, SQLException {
		
		java.sql.Date date1=new Date(new SimpleDateFormat("dd-MM-yyyy").parse("28-02-2020").getTime());
		
		assertEquals(1,dao.viewScheduledFlights("Bangalore","Delhi",date1).size());
		
	}

	@Test
	public void testViewScheduledFlightsLong() throws SQLException {
		
		assertNotNull(dao.viewScheduledFlights(50006));
	}

	@Test
	public void testViewScheduledFlight() throws SQLException {
		
		assertEquals(9,dao.viewScheduledFlight().size());
	}

}
