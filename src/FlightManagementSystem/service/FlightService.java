package FlightManagementSystem.service;
import java.sql.SQLException;

import FlightManagementSystem.Exception.FlightServiceException;


public interface FlightService {

	
	
	
	public void viewFlight() throws SQLException;
	public void deleteFlight(long flightNUmber)throws SQLException, FlightServiceException;
	//public void validateFlight(FlightDto flight1)throws SQLException;
	public void addFlight() throws FlightServiceException, SQLException;
	public void modifyFlight() throws FlightServiceException, SQLException;
	public void searchFlight(long flightNumber) throws FlightServiceException, SQLException;
}
