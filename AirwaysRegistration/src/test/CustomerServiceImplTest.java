package test;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import model.Booking;
import model.FlightBean;
import service.CustomerService;
import service.CustomerServiceImpl;

public class CustomerServiceImplTest {

	CustomerService csi = new CustomerServiceImpl();

	@Test
	@Disabled
	public void ticketBookingTest() throws ClassNotFoundException, SQLException {
		Booking b = new Booking();
		b.setFlightid(6);
		b.setUserid(3);
		b.setPassengerName("Suraj");
		b.setPassengerAge("25");
		b.setPassengerMobile("7777882525");
		b.setPassengerEmail("sur@gmail.com");
		b.setNumberOfSeat("6");
		int result = csi.ticketBooking(b);
		int actual = 1;
		assertEquals(result, actual);
	}

	@Test
	public void viewJourneyTest() throws ClassNotFoundException,SQLException{
		boolean expected = true;
		boolean actual = false;
		List<FlightBean> arr = new ArrayList<FlightBean>();
		arr = csi.viewJourney();
		for (int i = 0; i < arr.size(); i++) {
			if (!arr.get(i).getFlightName().equals(null)) {
				actual = true;
			}
		}
		assertEquals(expected,actual);
	}
}
