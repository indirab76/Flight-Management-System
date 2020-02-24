package FlightManagementSystem.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import FlightManagementSystem.Dao.UserDaoImpl;
import FlightManagementSystem.Dto.UserDto;
import FlightManagementSystem.Exception.UserServiceException;
import FlightManagementSystem.service.UserServiceImpl;

public class SignUp {
	
	UserDto user=new UserDto(); 
	
	Scanner sc=new Scanner(System.in);
	
	public void signupmaster() throws SQLException, UserServiceException{   
		
	UserServiceImpl userService=null ;
	System.out.println("\n<--------------------------------Welcome to SignUp Page------------------------------->");
	
	try {
		userService=new UserServiceImpl() ;
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.err.println(e1.getMessage());
	}
	
	userService.addUser();
		
	}
}
	


