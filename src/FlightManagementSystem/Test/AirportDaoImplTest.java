package FlightManagementSystem.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FlightManagementSystem.Dao.AirportDao;
import FlightManagementSystem.Dao.AirportDaoImpl;

public class AirportDaoImplTest {
    AirportDaoImpl dao;
	@Before
	public void setUp() throws Exception {
	  dao=new AirportDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	 dao=null;
	}


	@Test()
	public void testViewAirport() throws SQLException {
		assertNotNull(dao.viewAirport("DEL"));
	}

	@Test
	public void testViewAirportString() throws SQLException {
	assertEquals(4,dao.viewAirport().size());
	}

}
