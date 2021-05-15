package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import model.UserBean;
import service.UserServiceImpl;
import service.Userservice;

public class UserServiceImplTest {
	private	Userservice usi=new UserServiceImpl();


	@Test
	@Disabled
	public void signUSpUserTest() throws ClassNotFoundException, SQLException {
		UserBean ub=new UserBean();
		ub.setUserName("Sachin");
		ub.setCity("Varanasi");
		ub.setEmail("sachu@gmail.com");
		ub.setMobileNo("888889999");
		ub.setPassword("sac123");
		int result=usi.signupUser(ub);
		int	excpected=1;
		assertEquals(result, excpected);
	}

	@Test
	public void loginUserTest() throws ClassNotFoundException, SQLException {
		
		UserBean ub=new UserBean();
		ub.setUserName("Sachin");
		ub.setPassword("sac123");
		int result=usi.loginUser(ub);
		int expected=10;
		assertEquals(expected, result);
	}
}
