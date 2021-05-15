package service;

import java.sql.SQLException;

import model.UserBean;

public interface Userservice {
	int signupUser(UserBean userBean) throws ClassNotFoundException,SQLException;
	int loginUser(UserBean userBean) throws ClassNotFoundException, SQLException;
	
}
