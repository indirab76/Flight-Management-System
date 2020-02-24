package FlightManagementSystem.service;

import java.util.*;

import java.sql.SQLException;
import FlightManagementSystem.Exception.*;
import FlightManagementSystem.Dao.*;
import FlightManagementSystem.Dto.*;

public interface UserService {



	
	public void viewUser(long userId) throws UserServiceException, SQLException;
	public void viewUser() throws SQLException;
	 public void deleteUser(long userId) throws UserServiceException, SQLException;
	
	 public void updateUser(long userId) throws UserServiceException, SQLException;
	void addUser() throws SQLException, UserServiceException;
	public boolean validateUser(Long userId, String password, String userType) throws UserServiceException, SQLException;
	
	

}
