package FlightManagementSystem.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FlightManagementSystem.Dao.BookingDaoImpl;
import FlightManagementSystem.Dto.BookingDto;
import FlightManagementSystem.Dto.PassengerDto;

public class BookingDaoImplTest {
	BookingDaoImpl dao;

	@Before
	public void setUp() throws Exception {
		dao = new BookingDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testAddBooking() throws SQLException {

		BookingDto booking1 = new BookingDto();
		booking1.setFlightNumber(40003);
		booking1.setNoOfPassengers(4);
		booking1.setTicketCost(56000);
		booking1.setScheduleid(50008);
		booking1.setUserId(10014);
		assertNotNull(dao.addBooking(booking1));

	}

	@Test
	public void testAddPassenger() throws SQLException {
		PassengerDto passengerdto = new PassengerDto();

		passengerdto.setBookingId(20019);
		passengerdto.setLuggage(5.32f);
		passengerdto.setPassengerAge(12);
		passengerdto.setPassengerName("Bentinck");
		passengerdto.setPassengerUIN(1234545);
		//passengerdto.setPnrNumber(95);

		List<PassengerDto> al = new ArrayList<PassengerDto>();

		al.add(passengerdto);

		assertEquals(1, dao.addPassenger(al).size());

	}

	@Test
	public void testViewBookingLong() throws SQLException {
       
		assertNotNull(dao.viewBooking(20009));
	}

	@Test
	public void testViewBooking() throws SQLException {
		
		assertEquals(17,dao.viewBooking().size());
	}

	@Test
	public void testViewPassenger() throws SQLException {
		
		assertEquals(1,dao.viewPassenger(20019).size());
	}

	@Test
	public void testDeleteBooking() {
	}

}
