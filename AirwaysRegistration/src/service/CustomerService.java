package service;

import java.sql.SQLException;
import java.util.List;

import model.Booking;
import model.FlightBean;

public interface CustomerService {
	int ticketBooking(Booking b) throws ClassNotFoundException,SQLException;	
	List<FlightBean> viewJourney() throws ClassNotFoundException,SQLException;
}
