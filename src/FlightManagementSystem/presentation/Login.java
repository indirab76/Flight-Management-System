package FlightManagementSystem.presentation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import FlightManagementSystem.service.*;
import FlightManagementSystem.Exception.BookingServiceException;
import FlightManagementSystem.Exception.FlightServiceException;
import FlightManagementSystem.Exception.ScheduledFlightException;
import FlightManagementSystem.Exception.UserServiceException;

public class Login {
	
	

	UserServiceImpl userService;
	Scanner sc= new Scanner(System.in);
	
public void loginmaster() throws UserServiceException, SQLException{
	
	System.out.println("\n<--------------------------------Welcome to Login Page------------------------------->");
	
	System.out.println("\nKindly Enter the Following Details");
	
	System.out.println("Enter UserId : ");
	Long userId=sc.nextLong();
	
	System.out.println("Enter Password :");
	String password=sc.next();
	
	System.out.println("Enter UserType :");
	String userType=sc.next();
	
	
	userService=new UserServiceImpl();
	if( userService.validateUser(userId,password,userType)) {
		if(userType.equals("Admin"))
			masterAdmin();
		
		else if(userType.equals("Customer"))
			mastercustomer(userId);
		
		else
			System.out.println("User Type Invalid.");
			
	}	
}

public void masterAdmin()
{
	// menu-driven
	Scanner scanner = new Scanner(System.in);
	String ch;
	System.out.println("\n<--------------------------------Welcome Admin------------------------------->");
		/*--------------------------------------------------------Object Creation ---------------------------*/
			FlightService service1 = null;
			ScheduledFlightService service2 = null;
			AirportServiceImpl service3=null;
			try {
				service1 = new FlightServiceImpl();
				service2 = new ScheduledFlightServiceImpl();
				service3= new AirportServiceImpl();
				
				  while (true)
				   {
					   
					   
							System.out.println("\nSelect Admin Operation you want to perform: ");
							System.out.println("1.Add Flight");
							System.out.println("2.View Flight");
							System.out.println("3.Modify Flight");
							System.out.println("4.Search Flight");
							System.out.println("5.Delete Flight");
							
							
							System.out.println("6.Schedule Flight");
							System.out.println("7.View Scheduled Flight");
							System.out.println("8.Modify Scheduled Flight");
							System.out.println("9.Delete Scheduled Flight");
							System.out.println("10.View all Airports");
							System.out.println("11.Logout");
							
						int op = scanner.nextInt();
						switch (op){
						case 1:
							service1.addFlight();
							break;
						case 2:
							service1.viewFlight();
							break;
						case 3:
							service1.modifyFlight();
							break;
						case 4:
							System.out.println("Enter Flight Number: ");
							long flightNumber=scanner.nextLong();
							service1.searchFlight(flightNumber);
							break;
						case 5:
							System.out.println("Enter Flight Number: ");
							 flightNumber=scanner.nextLong();
							service1.deleteFlight(flightNumber);
							break;
						case 6:
							service2.scheduleFlight();
							break;
						case 7:
							service2.viewScheduleFlight();
							break;
						case 8:
							service2.modifyScheduleFlight();
							break;
						case 9:
							service2.deleteScheduleFlight();
							break;
						case 10:service3.viewAirport();
							break;
						case 11:System.out.println("Thank you for using !!!!");
						    break;
						
						default:System.out.println("Incorrect input!!! Please re-enter");
					}	//switch
				    	
				System.out.println("Do you want to Logout? yes\\no");
				ch = scanner.next();
				if(ch.equalsIgnoreCase("no"))
					continue;
				else
					break;
				}//While
			} //try
			catch (SQLException e1) {
				e1.printStackTrace();
				System.err.println(e1.getMessage());
			} 
			catch (FlightServiceException e2) {
				e2.printStackTrace();
				System.err.println(e2.getMessage());
			}
			catch(ScheduledFlightException e3) {
				e3.printStackTrace();
				System.err.println(e3.getMessage());
			}
			catch(ParseException e4) {
				e4.printStackTrace();
				System.err.println(e4.getMessage());
			}
		/*-------------------------------------------------------------------------------------------------------------------*/
	  
		
}//masterAdmin()

public void mastercustomer(long userId)
{
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("\n<--------------------------------Welcome Customer------------------------------->");
	   BookingServiceImpl bookingserviceimpl = null;
	   UserServiceImpl userserviceimpl = null;
	   ScheduledFlightServiceImpl scheduleflightserviceimpl = null;
	   String ch;
		try {
			
			bookingserviceimpl=new BookingServiceImpl();
			userserviceimpl=new UserServiceImpl();
			scheduleflightserviceimpl=new ScheduledFlightServiceImpl();
			
		while(true)
			
		{
		
	   System.out.println("Please enter your choice");
	   System.out.println();
	   System.out.println("1. SearchFlights\n2. BookFlight\n3. ViewBooking\n4. CancelBooking\n5. ViewUser\n6. UpdateUser\n7. DeleteUser\n8. Logout");
	   
	    int choice = sc.nextInt();
	   
	   
	   switch (choice)
	   {
	   
	case 1:
		
		scheduleflightserviceimpl.searchFlight();	 
		break;
		
	case 2:
		
		bookingserviceimpl.addBooking(userId);
		break;
		
	case 3:
		     System.out.println("Enter your BookingId: ");
			 bookingserviceimpl.viewBooking(sc.nextLong());
		     break;
	
	
	case 4: 
		     System.out.println("Enter your BookingId: ");
			 bookingserviceimpl.deleteBooking(sc.nextLong());
		      break;
 case 5: 
		
			 userserviceimpl.viewUser(userId);
		break;
		
 case 6: 
				 userserviceimpl.updateUser(userId);;
			break;
			
		
 case 7: 
			userserviceimpl.deleteUser(userId);;
				
		    break;
				
 case 8: 
 	System.out.println("Thank you for using !!!!");
		break;
	
	default:System.out.println("Incorrect input!!! Please re-enter");
	         break;
					
	   }			
	   System.out.println("Do you want to Logout? yes\\no");
		ch = sc.next();
		if(ch.equalsIgnoreCase("no"))
			continue;
		else
			break;			
		
	}
}catch(BookingServiceException e) {
	e.printStackTrace();
	System.err.println(e.getMessage());
}catch(UserServiceException e) {
	e.printStackTrace();
	System.err.println(e.getMessage());
}catch(SQLException e) {
	e.printStackTrace();
	System.err.println(e.getMessage());
}catch(ParseException e) {
	e.printStackTrace();
	System.err.println(e.getMessage());
}
	   
}



}