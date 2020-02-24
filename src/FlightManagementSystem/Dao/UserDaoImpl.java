package FlightManagementSystem.Dao;

import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import FlightManagementSystem.util.DatabaseUtil;
import FlightManagementSystem.Dto.UserDto;

public class UserDaoImpl implements UserDao {

	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	UserDto user;
	List<UserDto> userList;

	public UserDaoImpl() throws SQLException {
		
		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
	}

	/*--------------------Shows the details of a user identifiable by the user id----------------------*/
	
	@Override
	public UserDto viewUser(long user_id) throws SQLException {

		pst = connection.prepareStatement("select *from users where userId=?");
		pst.setLong(1, user_id);
		rs = null;
		rs = pst.executeQuery();
		
		if (rs.next()) {
			
			user = new UserDto();
			user.setUserType(rs.getString(1));
			user.setUserId(rs.getLong(2));
			user.setUserName(rs.getString(3));
			user.setUserPassword(rs.getString(4));
			user.setUserPhone(rs.getLong(5));
			user.setEmail(rs.getString(6));

		}
		
		return user;
	}
	
	/*--------------------Adds a new user-----------------------*/

	@Override
	public UserDto addUser(UserDto user1) throws SQLException {
		String ch;
		user=null;
		UserDto user2=new UserDto();
		Scanner sc = new Scanner(System.in);
		
		
			
			pst = null;
			pst = connection.prepareStatement("insert into users values(?,sequence_user.nextval,?,?,?,?)");
			pst.setString(1, user1.getUserType());
			
			pst.setString(2, user1.getUserName());
			pst.setString(3, user1.getUserPassword());
			pst.setLong(4, user1.getUserPhone());
			pst.setString(5, user1.getEmail());
			int res = pst.executeUpdate();
			
			if (res == 1) {
				System.out.println("Are you sure you want to submit? : yes\\no");
				ch = sc.next();
				if (ch.equalsIgnoreCase("yes"))
					connection.commit();
				else
					connection.rollback();
				
			}
			pst = connection.prepareStatement("select sequence_user.currval from dual");
			rs = null;
			rs = pst.executeQuery();
			if (rs.next()) {
            user1.setUserId(rs.getLong(1));
			}
	
		return user1;
	}
	
	/*-------------------Removes a user as per the user id---------------------*/

	@Override
	public void deleteUser(long user_id) throws SQLException {
		// TODO Auto-generated method stub
		pst = null;
		String ch;
		Scanner sc = new Scanner(System.in);
		pst = connection.prepareStatement("delete from users where userId=?");
		pst.setLong(1, user_id);

		int rst = pst.executeUpdate();

		if (rst == 1) {

			System.out.println("Are you sure you want to delete? : yes\\no");

			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();

			System.out.println("User with UserId:" + user_id + " has been deleted successfully.");

		}

		else
			System.out.println("Sorry! Some error occurred.");

	}

	/*----------------------Shows the details of all users-----------------------*/
	@Override
	public List<UserDto> viewUser() throws SQLException {

		userList = new ArrayList<UserDto>();

		pst = connection.prepareStatement("select *from users ");

		rs = null;
		rs = pst.executeQuery();
		user = null;
		while (rs.next()) {
			
			user = new UserDto();
			user.setUserType(rs.getString(1));
			user.setUserId(rs.getLong(2));
			user.setUserName(rs.getString(3));
			user.setUserPassword(rs.getString(4));
			user.setUserPhone(rs.getLong(5));
			user.setEmail(rs.getString(6));

			userList.add(user);

		}
		return userList;
	}

	/*-------------------Updates the details of a user-----------------*/
	@Override
	public UserDto updateUser(UserDto user1) throws SQLException {

		pst = null;
		String ch;
		Scanner sc=new Scanner(System.in);
		pst = connection.prepareStatement("update users set userType=?,userName=?, userPassword=?, userPhone=?,email=? where userId=?");

		pst.setString(1, user1.getUserType());
		pst.setString(2, user1.getUserName());
		pst.setString(3, user1.getUserPassword());
		pst.setLong(4, user1.getUserPhone());
		pst.setString(5, user1.getEmail());
		pst.setLong(6, user1.getUserId());

		int rst = pst.executeUpdate();
		if (rst == 1) {
			System.out.println("Are you sure you want to update? : yes\\no");
			ch = sc.next();
			if (ch.equalsIgnoreCase("yes"))
				connection.commit();
			else
				connection.rollback();
			return user1;
		} 
		else
			return null;
	}

	

}
