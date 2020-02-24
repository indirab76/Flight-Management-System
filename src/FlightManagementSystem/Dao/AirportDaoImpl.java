package FlightManagementSystem.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FlightManagementSystem.util.DatabaseUtil;
import FlightManagementSystem.Dto.AirportDto;

public class AirportDaoImpl implements AirportDao {

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;

	List<AirportDto> airportList;
	AirportDto airport;

	public AirportDaoImpl() throws SQLException {
		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
	}

	/*--------------------Returns the list of all airports----------------------*/

	@Override
	public List<AirportDto> viewAirport() throws SQLException {
		// TODO Auto-generated method stub

		airportList = new ArrayList<AirportDto>();

		pst = connection.prepareStatement("select *from airport ");

		rs = null;
		rs = pst.executeQuery();
	while (rs.next()) {
			airport = null;
			airport = new AirportDto();
			airport.setAirportName(rs.getString(1));
			airport.setAirportLocation(rs.getString(2));
			airport.setAirportCode(rs.getString(3));

			airportList.add(airport);

		}
		return airportList;

	}

	/*----------------------Returns the details of an airport identifiable by the airport code------------------------*/

	@Override
	public AirportDto viewAirport(String airportCode) throws SQLException {
		// TODO Auto-generated method stub

		pst = connection.prepareStatement("select *from airport where airportCode=?");
		pst.setString(1, airportCode);
		rs = null;
		rs = pst.executeQuery();
		airport = null;
		if (rs.next()) {
			airport = null;
			airport = new AirportDto();
			airport.setAirportName(rs.getString(1));
			airport.setAirportLocation(rs.getString(2));
			airport.setAirportCode(rs.getString(3));

		}
		return airport;
	}

}