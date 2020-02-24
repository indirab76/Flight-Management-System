package FlightManagementSystem.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FlightManagementSystem.Dao.BookingDaoImpl;
import FlightManagementSystem.Dao.UserDaoImpl;
import FlightManagementSystem.Dto.UserDto;

public class UserDaoImplTest {
	UserDaoImpl dao;
	UserDto user;
	@Before
	public void setUp() throws Exception {
		dao = new UserDaoImpl();
		user=new UserDto();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
		user=null;
	}

	@Test
	public void testViewUserLong() throws SQLException {
		assertNotNull(dao.viewUser(10014));
	}

	@Test
	public void testAddUser() throws SQLException {
		
		user.setUserName("Bentinck");
		user.setUserPassword("bini");
		user.setUserType("Customer");
		user.setUserPhone(9458);
		user.setEmail("bentinck12@gmail.com");
		
		assertNotNull(dao.addUser(user));
		
	}


	@Test
	public void testViewUser() throws SQLException {
		
		assertEquals(18,dao.viewUser().size());
	}

	

}
