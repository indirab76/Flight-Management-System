package FlightManagementSystem.Dao;

import java.sql.SQLException;
import java.util.*;
import FlightManagementSystem.Dto.UserDto;

public interface UserDao {

	
	public UserDto viewUser(long user_id) throws SQLException;
	public List<UserDto> viewUser() throws SQLException;
	public void deleteUser(long user_id) throws SQLException;
	public UserDto addUser(UserDto user1) throws SQLException;
	public UserDto updateUser(UserDto user1) throws SQLException;
	
}
