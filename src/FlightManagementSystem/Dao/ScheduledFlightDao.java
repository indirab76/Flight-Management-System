package FlightManagementSystem.Dao;
import java.sql.SQLException;
import java.util.*;
import FlightManagementSystem.Dto.*;
public interface ScheduledFlightDao {

	public ScheduledFlightDto scheduleFlight(ScheduledFlightDto scheduledFlight) throws SQLException;
	public ScheduledFlightDto viewScheduledFlights(long flightNumber) throws SQLException;
	public List<ScheduledFlightDto> viewScheduledFlight() throws SQLException;
	public void deleteScheduledFlight(long flightNumber) throws SQLException;
	public ScheduledFlightDto modifyScheduledFlight(ScheduledFlightDto scheduledflight1) throws SQLException;
	public List<ScheduledFlightDto> viewScheduledFlights(String airport1, String airport2, java.sql.Date date)throws SQLException;
}
