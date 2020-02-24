package FlightManagementSystem.service;
import FlightManagementSystem.Exception.*;



import java.sql.SQLException;

import java.util.*;
import FlightManagementSystem.Dao.UserDaoImpl;

import FlightManagementSystem.Dao.*;
import FlightManagementSystem.Dto.*;

public class UserServiceImpl implements UserService{
	
	
	UserDaoImpl userDao;
	
	
	public UserServiceImpl() throws SQLException {
		userDao=new UserDaoImpl();
		// TODO Auto-generated constructor stub
	}
	UserDto user=new UserDto();
	UserDto user1=new UserDto();
	Scanner scanner=new Scanner(System.in);
	
	//*****************************ADD USER _METHOD_1*********************************************/

	@Override
	public void addUser() throws SQLException,UserServiceException{
		
	//***********ENTER NAME/*************************************/
		
		System.out.println("Test");
		System.out.println("Enter Name :");
		String name=scanner.nextLine();
		if(name.isEmpty())
			throw new UserServiceException("Sorry!Name Field is Empty.");
		else
		     user.setUserName(name);
		
		//***************************USER TYPE************************************
		System.out.println("Enter UserType"+"1.Customer"+"2.Admin");
		String nametype=scanner.nextLine();
		if(nametype.isEmpty())
		throw new UserServiceException("Sorry!UserType Field is Empty.");
		else
				user.setUserType(nametype);
		
//*************************************Enter Email*****************************/
		
		System.out.println("Enter Password");
		String userPassword=scanner.next();
		
		if(userPassword.isEmpty())
			throw new UserServiceException("Sorry!Password Field is Empty.");
		else
		    user.setUserPassword(userPassword);
		
		
//*******************************Phone no************************
		
		System.out.println("Enter PhoneNo");
       long phoneNo=scanner.nextLong();
       String len=Long.toString(phoneNo);
       
		if(len.isEmpty())
			throw new UserServiceException("Sorry!PhoneNO Field is Empty.");
		else {
			if(len.length()==10 && len.charAt(0)!='0')
				user.setUserPhone(phoneNo);
			else
				throw new UserServiceException("Sorry!Invalid PhoneNumber.");
		}	
	

//************************Email Id******************************

System.out.println("Enter Email_Id");
String emailId=scanner.next();
if(emailId.isEmpty())
	throw new UserServiceException("Sorry!EmailId Field is Empty.");
else {
	EmailValidator email=new EmailValidator();
	boolean b=email.validateEmail(emailId);
	if(b)
		user.setEmail(emailId);
	else
		throw new UserServiceException("Sorry!Invalid EmailId.");}
     
     user1=userDao.addUser(user);
    // System.out.println(user1.getUserId());
     if(user1==null)
    	 throw new UserServiceException("Some Error occured");
     else
    	 viewUser(user1.getUserId());
}
	
	//********************************METHOD_2  VIEW BY ID************************************
	
	public void viewUser(long userId) throws UserServiceException, SQLException
{
	
	
	if(userId==0)
		throw new UserServiceException("Sorry!UserId Field is Empty.");
	else
	{
	   user=userDao.viewUser(userId);	
	   
	System.out.println("User Details are displayed below:");
	System.out.println("UserId: "+user.getUserId());
	System.out.println("User Name: "+user.getUserName());
	System.out.println("User Password: "+user.getUserPassword());
	System.out.println("User Type: "+user.getUserType());
	System.out.println("User Phone: "+user.getUserPhone());
	System.out.println("User EmailId: "+user.getEmail());
	}
	
}
	
	//********************METHOD_3 VIEWDETAILS***************************
	
	public void viewUser() throws SQLException
	{
          List<UserDto> userlist =new ArrayList<UserDto>();
          
           userlist=userDao.viewUser();
        System.out.println("User_Id"+"  "+"User_Name"+"  "+"User_Password"+"  "+"User_Type"+"  "+"User_PhoneNo"+"  "+"UsrEmailId");
       
        for(UserDto u:userlist) {
        	
        	System.out.println(u.getUserId()+"  "+u.getUserName()+"  "+u.getUserPassword()+"  "+u.getUserType()+"  "+u.getUserPhone()+"  "+u.getEmail());
        	}
           
		
	}
	//***********************************METHOD_4 UpdateUser***************************************
	@Override
	public void updateUser(long userId) throws UserServiceException, SQLException
	{   System.out.println("Which field in your account do you want to update?\n1.UserName\n2.UserPassword\n3.UserType\n4.UserPhoneNo\n5.UserEmailId");
	    int ch=scanner.nextInt();
	    
	    switch(ch) {
	    case 1:
	    	System.out.print("Enter User Name: ");
	    	String userName=scanner.next();
	    	if(userName.isEmpty())
	    	throw new UserServiceException("entered name is null");
	    	else
	    	user.setUserName(userName);
	    	break;

	    case 2:
	    	System.out.println("Enter User Password: ");
	    	String userPassword=scanner.next();
	    	if(userPassword.isEmpty())
		    	throw new UserServiceException("entered password is null");
	    	else
	    	user.setUserPassword(userPassword);
	    	break;
	    	
	    case 3:
	    	System.out.println("Enter User Type: ");
	    	String userType=scanner.next();
	    	if(userType.isEmpty())
		    	throw new UserServiceException("entered nametype is null");
	    	else
	    	user.setUserType(userType);
	    	break;
	    
	    case 4:
	    	System.out.println("Enter User PhoneNo: ");
	    	Long userPhoneNo=scanner.nextLong();
	            String len=Long.toString(userPhoneNo);
	    	       if(len.isEmpty())
	    				throw new UserServiceException("Sorry!PhoneNO Field is Empty.");
	    			else {
	    				if(len.length()==10 && len.charAt(0)!='0')
	    					user.setUserPhone(userPhoneNo);
	    	}
	    	break;	
	    	
	    case 5:
	    	System.out.println("Enter User EmailId: ");
	    	String userEmailId=scanner.next();
	    		if(userEmailId.isEmpty())
	    		throw new UserServiceException("Sorry!EmailId Field is Empty.");
	    	else {
	    		EmailValidator email=new EmailValidator();
	    		boolean b=email.validateEmail(userEmailId);
	    		if(b)
	    			user.setEmail(userEmailId);
	    		else
	    			throw new UserServiceException("Sorry!Invalid EmailId.");
	    		}
	    	     
	    	  break;
	    }

	    	 user=userDao.updateUser(user);
	         if(user==null)
	        	 throw new UserServiceException("Some Error occured");
	         else
	        	 viewUser(user.getUserId());

	}
	
	//********************************************METHOD_5 DELETE USER**********************************************
	    @Override
	    public void deleteUser(long userId) throws UserServiceException, SQLException
	    {
	    	
	    	if(userId==0)
	    		throw new UserServiceException("Sorry!UserId Field is Empty.");
	    	else
	    	{
	    	userDao.deleteUser(userId);
	     }
	    	
	    	
	    	
	    }
	    
	
	//************************************METHOD_6 VALIDATE USER************************************************
	@Override
	public boolean validateUser(Long userId,String password,String userType) throws UserServiceException, SQLException {
	UserDto user1=new UserDto();
	Boolean b;
	user1=userDao.viewUser(userId);
	
	if(user1!=null) {
		if(user1.getUserId()==userId||user1.getUserPassword()==password||user1.getUserType()==userType) {
			return true;
		}
		
	}else 
		throw new UserServiceException("UserId not present.");
	
	return false;
	}
		
	
}
