package FlightManagementSystem.service;
import java.sql.SQLException;
import java.util.*;

import FlightManagementSystem.Dao.AirportDaoImpl;
import FlightManagementSystem.Dao.FlightDaoImpl;
import FlightManagementSystem.Dto.AirportDto;

public class AirportServiceImpl {

	List<AirportDto>airportlist ;
	AirportDaoImpl airportDao;
	
	public AirportServiceImpl() throws SQLException {
		airportDao=new AirportDaoImpl();
		// TODO Auto-generated constructor stub
	}
	public void viewAirport() throws SQLException {
		// TODO Auto-generated method stub
		
		   airportlist =new ArrayList<AirportDto>();
	          
           airportlist=airportDao.viewAirport();
           
        System.out.println("Airport_Name    Airport_Code    Airport_Location");
       
        for(AirportDto a :airportlist) {
        	
        	System.out.println(a.getAirportName()+"          "+a.getAirportCode()+"         "+a.getAirportLocation());
        	}
		
	}
}
