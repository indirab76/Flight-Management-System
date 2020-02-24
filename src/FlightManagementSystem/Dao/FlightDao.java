package FlightManagementSystem.Dao;

import java.sql.SQLException;
import java.util.List;
import FlightManagementSystem.Dto.FlightDto;

public interface FlightDao {

	public FlightDto addFlight(FlightDto flight1)throws SQLException;
	public FlightDto viewFlight(long flightNumber)throws SQLException;
	public List<FlightDto> viewFlight()throws SQLException;
	public FlightDto modifyFlight(FlightDto flight1)throws SQLException;
	public void deleteFlight(long flightNumber)throws SQLException;
}
