package FlightManagementSystem.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FlightManagementSystem.Dao.FlightDaoImpl;
import FlightManagementSystem.Dto.FlightDto;

public class FlightDaoImplTest {

	FlightDaoImpl flightDaoImpl;
	FlightDto flightdto;
	@Before
	public void setUp() throws Exception {
		flightDaoImpl=new FlightDaoImpl();
		 flightdto=new FlightDto();
	}

	@After
	public void tearDown() throws Exception {
		flightDaoImpl=null;
		flightdto=null;
	}


	@Test
	public void testViewFlightLong() throws SQLException {
	
		assertNotNull(flightDaoImpl.viewFlight(40003));
		//assertEquals(4,dao.viewAirport().size());
	}

	@Test
	public void testAddFlight() throws SQLException {
     flightdto.setCarrierName("Boeing");
     flightdto.setFlightModel("A500");
     flightdto.setSeatCapacity(100);
     
     assertNotNull(flightDaoImpl.addFlight(flightdto));
     
	}

	@Test
	public void testViewFlight() throws SQLException {
		assertEquals(7,flightDaoImpl.viewFlight().size());
	}

	@Test
	public void testModifyFlight() throws SQLException {
		 flightdto.setCarrierName("Boeing");
	     flightdto.setFlightModel("A500");
	     flightdto.setFlightNumber(40005);
	     flightdto.setSeatCapacity(100);
	     
	     assertNotNull(flightDaoImpl.modifyFlight(flightdto));
	}

}
