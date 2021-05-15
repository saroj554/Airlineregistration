package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.CustomerDaoImpl;
import model.Booking;
import model.FlightBean;
import util.DbuUility;

class CustomerDaoTest {

	private CustomerDaoImpl cdi=new CustomerDaoImpl();
	
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
  void	ticketBookingTest() throws ClassNotFoundException, SQLException {
		
		Booking b=new Booking();
		b.setFlightid(6);
		b.setUserid(3);
		b.setPassengerName("Harsh");
		b.setPassengerAge("23");
		b.setPassengerMobile("9999555548");
		b.setPassengerEmail("Har@gmail.com");
		b.setNumberOfSeat("5");
		int result=cdi.ticketBooking(b);
		int expected = 1;
		assertEquals(result,expected);
	}

	@Test
	@Disabled
	void viewJourneyTest() throws ClassNotFoundException,SQLException 
	{
		boolean expected = true;
		boolean actual = false;
		List<FlightBean> arr = new ArrayList<FlightBean>();
		arr = cdi.viewJourney();
		for(int i=0;i<arr.size();i++) {
			if(!arr.get(i).getFlightName().equals(null)) {
				actual = true;
			}
		}
		assertEquals(expected,actual);
	}



@Test

void viewPassengerTest() throws ClassNotFoundException, SQLException
{
	boolean expected = true;
	boolean actual = false;
	List<Booking> arr = new ArrayList<Booking>();
	arr = cdi.viewPassenger();
	for(int i=0;i<arr.size();i++) {
		if(!arr.get(i).getPassengerName().equals(null)) {
			actual = true;
		}
		assertEquals(expected,actual);
}
	
}
}
