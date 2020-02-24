package FlightManagementSystem.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

import FlightManagementSystem.Dto.*;
import FlightManagementSystem.Dao.*;
import FlightManagementSystem.util.DatabaseUtil;

public class ScheduledFlightDaoImpl implements ScheduledFlightDao{

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	FlightDto flight;
	FlightDao flightDao;
	AirportDao airportDao;
	ScheduledFlightDto scheduledflight;
	List<FlightDto> flightList;
	List<ScheduledFlightDto> scheduledFlightList;
	Scanner sc;
	
	public ScheduledFlightDaoImpl() throws SQLException {
		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
	}

	@Override
	public ScheduledFlightDto scheduleFlight(ScheduledFlightDto scheduledFlight1) throws SQLException {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		String ch;
		
		sc = new Scanner(System.in);
		
			pst = connection.prepareStatement("insert into scheduledflight values(sequence_scheduledflight.nextval,?,?,?,?,?,?,?,?)");
			
			
			pst.setLong(8, scheduledFlight1.getFlight());
			pst.setString(1, scheduledFlight1.getSourceAirport());
			pst.setString(2, scheduledFlight1.getDestinationAirport());
			pst.setDate(3, scheduledFlight1.getArrivalTime());
			pst.setDate(4, scheduledFlight1.getDepartureTime());
			pst.setInt(5, scheduledFlight1.getAvailableSeats());
			pst.setFloat(6, scheduledFlight1.getTicketCost());
			pst.setDate(7,scheduledFlight1.getBoardingDate());
			int res = pst.executeUpdate();
			
			if (res == 1) {
				System.out.println("Are you sure you want to add schedule? : yes\\no");
				ch = sc.next();
				if (ch.equalsIgnoreCase("yes"))
					connection.commit();
				else
					connection.rollback();
				
			} else
				return null;
			pst = connection.prepareStatement("select sequence_scheduledflight.currval from dual");
			rs = null;
			rs = pst.executeQuery();
			if (rs.next()) {
            scheduledFlight1.setScheduleId(rs.getLong(1));
              }
		return scheduledFlight1;
		
	}

	@Override
	public List<ScheduledFlightDto> viewScheduledFlights(String airport1,String airport2, Date date) throws SQLException {
		// TODO Auto-generated method stub
		
		scheduledFlightList=new ArrayList<ScheduledFlightDto>();
		
		pst = connection.prepareStatement("select *from scheduledflight where SOURCEAIRPORT_CODE=(select airportcode from airport where airportlocation=?) and DESTINATIONAIRPORT_CODE=(select airportcode from airport where airportlocation=?) and boardingdate=?");
		pst.setString(1, airport1);
		pst.setString(2, airport2);
		pst.setDate(3, date);
		rs = null;
		rs = pst.executeQuery();
		
		if (rs.next()) {
			scheduledflight = null;
			scheduledflight = new ScheduledFlightDto();
			scheduledflight.setScheduleId(rs.getLong(1));
			scheduledflight.setFlight(rs.getLong(9));
			scheduledflight.setSourceAirport(rs.getString(2));
			scheduledflight.setDestinationAirport(rs.getString(3));
			scheduledflight.setArrivalTime(rs.getDate(4));
			scheduledflight.setDepartureTime(rs.getDate(5));
			scheduledflight.setAvailableSeats(rs.getInt(6));
			scheduledflight.setTicketCost(rs.getInt(7));
			scheduledflight.setBoardingDate(rs.getDate(8));
			
			
			scheduledFlightList.add(scheduledflight);
			
		}
		return scheduledFlightList;
		
	}

	@Override
	public ScheduledFlightDto viewScheduledFlights(long scheduleId) throws SQLException {
		// TODO Auto-generated method stub
		
		pst = connection.prepareStatement("select*from scheduledflight where scheduleid=?");
		pst.setLong(1, scheduleId);
		rs = null;
		rs = pst.executeQuery();
		
		scheduledflight = null;
		scheduledflight = new ScheduledFlightDto();
		if (rs.next()) {
			
			scheduledflight.setScheduleId(rs.getLong(1));
			scheduledflight.setFlight(rs.getLong(9));
			scheduledflight.setSourceAirport(rs.getString(2));
			scheduledflight.setDestinationAirport(rs.getString(3));
			scheduledflight.setArrivalTime(rs.getDate(4));
			scheduledflight.setDepartureTime(rs.getDate(5));
			scheduledflight.setAvailableSeats(rs.getInt(6));
			scheduledflight.setTicketCost(rs.getInt(7));
			scheduledflight.setBoardingDate(rs.getDate(8));
			
			
		}
		return scheduledflight;
		
	}

	@Override
	public List<ScheduledFlightDto> viewScheduledFlight() throws SQLException {
		// TODO Auto-generated method stub
		pst = connection.prepareStatement("select *from scheduledflight ");
		
		rs = null;
		rs = pst.executeQuery();
		scheduledFlightList=new ArrayList<ScheduledFlightDto>();
		
		while (rs.next()) {
			scheduledflight = null;
			scheduledflight = new ScheduledFlightDto();
			scheduledflight.setScheduleId(rs.getLong(1));
			scheduledflight.setFlight(rs.getLong(9));
			scheduledflight.setSourceAirport(rs.getString(2));
			scheduledflight.setDestinationAirport(rs.getString(3));
			scheduledflight.setArrivalTime(rs.getDate(4));
			scheduledflight.setDepartureTime(rs.getDate(5));
			scheduledflight.setAvailableSeats(rs.getInt(6));
			scheduledflight.setTicketCost(rs.getInt(7));
			scheduledflight.setBoardingDate(rs.getDate(8));
			
			
			scheduledFlightList.add(scheduledflight);
			
		}
		return scheduledFlightList;
		
	}

	@Override
	public ScheduledFlightDto modifyScheduledFlight(ScheduledFlightDto scheduledflight1) throws SQLException {
		// TODO Auto-generated method stub

		pst=null;
			
			pst = connection.prepareStatement("update users set "
					+ "flightnumber=?,sourceairport_code=?,sourceairport_code=?,arrivaltime=to_date(?,'HH24:MI:SS'),departuretime=to_date(?,'HH24:MI:SS'),"
					+ "availableseat=?,ticketcost=?,boardingdate=to_date(?,'DD-MM-YYYY')) where scheduleid=?");
			
			String ch;
			
			
			pst.setLong(1, scheduledflight1.getFlight());
			pst.setString(2, scheduledflight1.getSourceAirport());
			pst.setString(3, scheduledflight1.getDestinationAirport());
			pst.setDate(4, scheduledflight1.getArrivalTime());
			pst.setDate(5, scheduledflight1.getDepartureTime());
			pst.setInt(6, scheduledflight1.getAvailableSeats());
			pst.setFloat(7, scheduledflight1.getTicketCost());
			pst.setDate(8,scheduledflight1.getBoardingDate());
			pst.setLong(9, scheduledflight1.getScheduleId());
			
			int res = pst.executeUpdate();
			
			if (res == 1) {
				System.out.println("Are you sure you want to add schedule? : yes\\no");
				ch = sc.next();
				if (ch.equalsIgnoreCase("yes"))
					connection.commit();
				else
					connection.rollback();
				return scheduledflight1;
			} else
				return null;

		
	}

	@Override
	public void deleteScheduledFlight(long scheduledId) throws SQLException {
		// TODO Auto-generated method stub
		
		pst = null;
		String ch;
		Scanner sc = new Scanner(System.in);
		pst = connection.prepareStatement("delete from scheduledflight where scheduleId=?");
		pst.setLong(1, scheduledId);
         
		int rst = pst.executeUpdate();
		
	

		if (rst ==1) {

			System.out.println("Are you sure you want to delete? : yes\\no");

			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();

			System.out.println("Schedule with ScheduleId:" + scheduledId + " has been deleted successfully.");

		}

		else
			System.out.println("Sorry! Some error occurred.");
		
	}
	
	

}
