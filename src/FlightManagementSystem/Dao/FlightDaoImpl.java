package FlightManagementSystem.Dao;

import java.sql.*;
import java.util.*;


import FlightManagementSystem.util.DatabaseUtil;
import FlightManagementSystem.Dto.FlightDto;

public class FlightDaoImpl implements FlightDao{

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	FlightDto flight;
	List<FlightDto> flightList;

	public FlightDaoImpl() throws SQLException {
		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
	}

	/*--------------------Shows the details of a flight specified by the flight number.----------------------*/
	
	@Override
	public FlightDto viewFlight(long flightNumber) throws SQLException {

		pst = connection.prepareStatement("select *from flight where flightNumber=?");
		pst.setLong(1, flightNumber);
		rs = null;
		rs = pst.executeQuery();
		
		if (rs.next()) {
			flight = null;
			flight = new FlightDto();
			
			flight.setFlightNumber(rs.getLong(1));
			flight.setCarrierName(rs.getString(2));
			flight.setFlightModel(rs.getString(3));
			flight.setSeatCapacity(rs.getInt(4));

		}
		return flight;
	}
	
	/*--------------------Adds a new flight which can be scheduled-----------------------*/

	@Override
	public FlightDto addFlight(FlightDto flight1) throws SQLException{
		String ch;
		
		Scanner sc = new Scanner(System.in);
		
		
			
			pst = null;
			pst = connection.prepareStatement("insert into flight values(sequence_flight.nextval,?,?,?)");
			
			pst.setString(1, flight1.getCarrierName());
			pst.setString(2, flight1.getFlightModel());
			pst.setInt(3, flight1.getSeatCapacity());
	
			int res = pst.executeUpdate();
			
			if (res == 1) {
				System.out.println("Are you sure you want to submit? : yes\\no");
				ch = sc.next();
				if (ch.equalsIgnoreCase("yes"))
					connection.commit();
				else
					connection.rollback();
				
			} else
				return null;
			
			 pst = connection.prepareStatement("select sequence_flight.currval from dual");
				rs = null;
				rs = pst.executeQuery();
				if (rs.next()) {
	            flight1.setFlightNumber(rs.getLong(1));
				}
				return flight1;

		
	}
	
	/*-------------------Removes a flight.---------------------*/

	@Override
	public void deleteFlight(long flightNumber) throws SQLException{
		// TODO Auto-generated method stub
		pst = null;
		String ch;
		Scanner sc = new Scanner(System.in);
		pst = connection.prepareStatement("delete from flight where flightNumber=?");
		pst.setLong(1, flightNumber);

		int rst = pst.executeUpdate();

		if (rst == 1) {

			System.out.println("Are you sure you want to delete? : yes\\no");

			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();

			System.out.println("Flight with FlightNumber:" + flightNumber + " has been deleted successfully.");

		}

		else
			System.out.println("Sorry! Some error occurred.");

	}

	/*----------------------View the details of all flights.-----------------------*/
	@Override
	public List<FlightDto> viewFlight() throws SQLException{

		flightList = new ArrayList<FlightDto>();

		pst = connection.prepareStatement("select *from flight ");

		rs = null;
		rs = pst.executeQuery();
		while (rs.next()) {
			flight = null;
			flight = new FlightDto();
			
			flight.setFlightNumber(rs.getLong(1));
			flight.setCarrierName(rs.getString(2));
			flight.setFlightModel(rs.getString(3));
			flight.setSeatCapacity(rs.getInt(4));
			

			flightList.add(flight);

		}
		return flightList;
	}

	/*-------------------Modify the details of a flight.-----------------*/
	@Override
	public FlightDto modifyFlight(FlightDto flight1) throws SQLException{

		pst = null;
		String ch;
		Scanner sc=new Scanner(System.in);
		pst = connection.prepareStatement("update flight set carrierName=?,flightModel=?, seatCapacity=? where flightNumber=?");

		pst.setString(1, flight1.getCarrierName());
		pst.setString(2, flight1.getFlightModel());
		pst.setInt(3, flight1.getSeatCapacity());
		pst.setLong(4, flight1.getFlightNumber());

		int rst = pst.executeUpdate();
		if (rst == 1) {
			System.out.println("Are you sure you want to update? : yes\\no");
			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();
			return flight1;
		} 
		else
			return null;
	}

	
}
