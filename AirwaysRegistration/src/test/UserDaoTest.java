package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.UserDAOImpl;
import model.UserBean;
import util.DbuUility;

class UserDaoTest {

	private UserDAOImpl udi= new UserDAOImpl();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DbuUility.getDbConnection();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DbuUility.getDbConnectionClose();
	}

	@Test
@Disabled
	void signUpUserTest() throws ClassNotFoundException, SQLException 
	{
		UserBean ub=new UserBean();
		ub.setUserName("Sanjay");
		ub.setCity("Bhagalpur");
		ub.setEmail("sanjay@yahoo.com");
		ub.setMobileNo("9959256547");
		ub.setPassword("san123");
		int result=udi.signupUser(ub);
		int excepted=1;
		assertEquals(result,excepted);
	}

	@Test

	void loginUserTest() throws ClassNotFoundException, SQLException 
	{
		UserBean ub=new UserBean();
		ub.setUserName("Sachin");
		ub.setPassword("sac123");
		int result=udi.loginUser(ub);
		int expected=10;
		assertEquals(expected,result);
	}
}
