package FlightManagementSystem.presentation;
import java.sql.SQLException;
import java.util.*;

import FlightManagementSystem.Exception.UserServiceException;

public class Controller {
	
	public static void main(String args[])
	{
		Login login=new Login();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\n<-----------------------------------Welcome to Flight Management System------------------------------------>");
		try {
			SignUp signup=new SignUp();
			
		while(true) {
		System.out.println("\nWhat do you want to perform: "+"\n1.LOGIN"+"\n2.SIGNUP"+"\n3.EXIT");
		int choice=sc.nextInt();
		
		switch(choice)
		
		{
		case 1:
			
			login.loginmaster();
			break;
			
		case 2:
			signup.signupmaster();
			break;
			
		case 3:
			System.exit(0);
			break;
			
		default:
			System.out.println("you have entered the wrong choice");
			
		}
		continue;
		}
		}catch(UserServiceException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}
}
	

