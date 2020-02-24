package FlightManagementSystem.service;
import java.sql.SQLException;
import java.util.*;


import FlightManagementSystem.Dao.FlightDaoImpl;
import FlightManagementSystem.Dao.UserDaoImpl;
import FlightManagementSystem.Exception.EmailValidator;
import FlightManagementSystem.Exception.FlightServiceException;
import FlightManagementSystem.Dto.FlightDto;

public class FlightServiceImpl implements FlightService{

	FlightDto flight;
	FlightDto flight2;
	FlightDaoImpl flightDao;
	Scanner sc=new Scanner(System.in);
	
	public FlightServiceImpl() throws SQLException {
		flightDao=new FlightDaoImpl();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void searchFlight(long flightNumber) throws FlightServiceException, SQLException{
		// TODO Auto-generated method stub
		
		 flight=new FlightDto();
		if(flightNumber==0)
			throw new FlightServiceException("Sorry!Flight Number field is empty.");
		else {
			flight=flightDao.viewFlight(flightNumber);
			System.out.println("Flight Details:");
			System.out.print("Enter Flight Number:"+flight.getFlightNumber());
			System.out.print("\nEnter Flight Model"+flight.getFlightModel());
			System.out.print("\nEnter Carrier Name:"+flight.getCarrierName());
			System.out.print("\nEnter Seat Capacity:"+flight.getSeatCapacity());
		}
		
	}
	
	

	@Override
	public void viewFlight() throws SQLException {
		// TODO Auto-generated method stub
		List<FlightDto> flightList=new ArrayList<FlightDto>();
		flightList=flightDao.viewFlight();
		
		System.out.println("FlightNumber  FlightModel  CarrierName SeatCapacity");
		
		for(FlightDto flight:flightList) {
			System.out.println(flight.getFlightNumber()+"       "+flight.getFlightModel()+"       "+flight.getCarrierName()+"       "+flight.getSeatCapacity());
			
		}
		
	}

	@Override
	public void deleteFlight(long flightNumber) throws FlightServiceException, SQLException {
		// TODO Auto-generated method stub
		
		if(flightNumber==0)
			throw new FlightServiceException("Sorry!Flight Number field is empty.");
		else {
			flightDao.deleteFlight(flightNumber);
		}
	}

	@Override
	public void addFlight() throws FlightServiceException, SQLException {
		
		flight=new FlightDto();
		flight2=new FlightDto();
		System.out.println("Enter Flight Details:");
		
		
		System.out.println("Enter Flight Model:");
		flight.setFlightModel(sc.next());
		System.out.println("Enter Seat Capacity:");
		flight.setSeatCapacity(sc.nextInt());
		System.out.println("Enter Carrier Name:");
		flight.setCarrierName(sc.next());
		
		flight2=flightDao.addFlight(flight);
		if(flight2==null) {
			throw new FlightServiceException("Sorry! Some error occured.");
		}
		else {
			searchFlight(flight2.getFlightNumber());
		}
	}
	
	@Override
	public void modifyFlight() throws FlightServiceException, SQLException {
		
		
		System.out.println("Enter Flight Number whose details you wish to modify:");
		long FlightNumber=sc.nextLong();
		System.out.println("Which field in flight do you want to update?\n1.FlightModel\n2.CarrierName\n3.SeatCapacity");
	    String ch=sc.next();
	    flight=null;
	    flight2=null;
	    flight=new FlightDto();
	    flight2=new FlightDto();
	    flight=flightDao.viewFlight(FlightNumber);
	    
	    switch(ch) {
	   
	    case "FlightModel":
	    	System.out.println("Enter Flight Model: ");
	    	String FlightModel=sc.next();
	    	if(FlightModel.isEmpty())
		    	throw new FlightServiceException("Entered flight model is null");
	    	else
	    	flight.setFlightModel(FlightModel);
	    	break;
	    	
	    case "CarrierName":
	    	System.out.println("Enter Carrier Name: ");
	    	String CarrierName=sc.next();
	    	if(CarrierName.isEmpty())
		    	throw new FlightServiceException("Entered carrier name is null");
	    	else
	    	flight.setCarrierName(CarrierName);
	    	break;
	    
	    case "SeatCapacity":
	    	System.out.println("Enter Seat Capacity: ");
	    	int SeatCapacity=sc.nextInt();
	    	if(SeatCapacity==0)
	    		throw new FlightServiceException("Entered seat capacity is null");
	    	else 
	    		flight.setSeatCapacity(SeatCapacity);
	    	break;	
	    	
	   
	    }

	    	 flight2=flightDao.modifyFlight(flight);
	         if(flight2==null)
	        	 throw new FlightServiceException("Some Error occured");
	         else
	        	 searchFlight(flight2.getFlightNumber());
		
	}
	
	/*@Override
	public void validateFlight(Flight flight1) {
		
	}*/
}
