package FlightManagementSystem.Dao;
import java.sql.SQLException;
import java.util.*;

import FlightManagementSystem.Dto.AirportDto;

public interface AirportDao {

	public List<AirportDto> viewAirport() throws SQLException;
	public AirportDto viewAirport(String airportCode) throws SQLException;
}
