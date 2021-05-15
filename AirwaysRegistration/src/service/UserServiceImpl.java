package service;

import java.sql.SQLException;

import dao.UserDAOImpl;
import dao.UserDao;
import model.UserBean;

public  class UserServiceImpl implements Userservice{
	private UserDao ud=new UserDAOImpl();
	public	int signupUser(UserBean userBean) throws ClassNotFoundException,SQLException
	{
		int rowsCount=0;
		try
		{

			rowsCount=ud.signupUser(userBean);
		}
		catch(ClassNotFoundException|SQLException e)
		{
			throw e;
		}
		return rowsCount;

	}
	public	int loginUser(UserBean userBean) throws ClassNotFoundException, SQLException
	{	
		UserDAOImpl ud=new UserDAOImpl();
	int flag=ud.loginUser(userBean);
		return flag;
		
	}
	

}
