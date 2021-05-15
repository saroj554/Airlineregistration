
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.UserBean;
import util.DbuUility;

public class UserDAOImpl implements UserDao{
	private static Connection connection=null;
	private static Statement statement=null;

	public	int signupUser(UserBean userBean) throws ClassNotFoundException,SQLException
	{
		int rowsCount=0;
		try
		{
			connection = DbuUility.getDbConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO user(userName, email, city, mobileNo, userPass) VALUES(?,?,?,?,?)");
			ps.setString(1,userBean.getUserName());
			ps.setString(2, userBean.getEmail());
			ps.setString(3,userBean.getCity());
			ps.setString(4,userBean.getMobileNo());
			ps.setString(5,userBean.getPassword());
			rowsCount= ps.executeUpdate();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbuUility.getDbConnectionClose();	
		}
		return rowsCount;
	}

	public	int loginUser(UserBean userBean) throws ClassNotFoundException, SQLException
	{
//		System.out.println("user = "+userBean.getUserName());
//		System.out.println("password = "+userBean.getPassword());
		
		int userID= 0;
		try 
		{
			String userName=userBean.getUserName();
			String user_password=userBean.getPassword();
			Connection con = DbuUility.getDbConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select userid from user Where userName= '"+userName+"' and userPass = '"+user_password+"'");
			if(rs.next())
			{
//				System.out.println(rs.getInt(1));
				userID = rs.getInt(1);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return userID;
	}
	
	
}


