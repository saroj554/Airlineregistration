package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.AdminDaoImpl;
import model.FlightBean;
import util.DbuUility;

class DaoTest {
	private AdminDaoImpl ob=new AdminDaoImpl();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DbuUility.getDbConnection();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DbuUility.getDbConnectionClose();
	}

	@Test
	void addFlightTest() {
		FlightBean cl=new FlightBean();
		cl.setFlightName("Emirates");
		cl.setSource("Patna");
		cl.setDestination("Delhi");
		cl.setTotalSeat("20");
		cl.setFlightDate("2021-05-21");
		cl.setAbvailableSeat("20");
		cl.setPrice("3500");
			
		int result = ob.addflight(cl);
		int expected = 1;
		assertEquals(result,expected);
		
		
		//fail("Not yet implemented");
	}
	
	@Test
 void updateTest() throws ClassNotFoundException, SQLException {
	 
	 FlightBean cl=new FlightBean();
	 cl.setFlightid(15);
		cl.setFlightName("Emirates");
		cl.setSource("Patna");
		cl.setDestination("Delhi");
		cl.setTotalSeat("20");
		cl.setFlightDate("2021-05-21");
		cl.setAbvailableSeat("20");
		cl.setPrice("3500");
		
		int result=ob.update(cl);
		int expected =1;
		assertEquals(result,expected);
 }
 
	@Test
 void deleteTest() 
	{
		int id=14;
		int result=ob.delete(id);
		int expected=1;
		assertEquals(result,expected);
	}
	
	@Test
	void getFlightByIdTest()
	{
		 FlightBean cl=new FlightBean();
		cl=ob.getFlightById(15);
	boolean actual=false;
	if(!cl.getFlightName().equals(null)) {
		actual = true;
	}
	boolean expected=true;
	assertEquals(expected,actual);
	}
}


