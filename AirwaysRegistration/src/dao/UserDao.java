package dao;

import java.sql.SQLException;

import model.UserBean;

public interface UserDao {
	int signupUser(UserBean userBean) throws ClassNotFoundException,SQLException;
	int loginUser(UserBean userBean) throws ClassNotFoundException, SQLException;
	
	
	}
