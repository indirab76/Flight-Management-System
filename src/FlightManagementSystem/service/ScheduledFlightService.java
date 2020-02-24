package FlightManagementSystem.service;

import java.sql.SQLException;
import java.text.ParseException;

import FlightManagementSystem.Dto.ScheduledFlightDto;
import FlightManagementSystem.Exception.ScheduledFlightException;

public interface ScheduledFlightService {

	public void modifyScheduleFlight() throws ParseException, SQLException;
	public void deleteScheduleFlight() throws SQLException;
	public void searchFlight() throws SQLException, ParseException;
	public void viewScheduleFlight() throws SQLException;
	public void viewScheduleFlight(ScheduledFlightDto scheduleDto);
	public void scheduleFlight() throws ParseException, ScheduledFlightException, SQLException;
}
