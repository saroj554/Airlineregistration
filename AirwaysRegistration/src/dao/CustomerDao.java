package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.FlightBean;


public interface CustomerDao {
	int ticketBooking(Booking b) throws ClassNotFoundException,SQLException;	
	List<FlightBean>   viewJourney() throws ClassNotFoundException,SQLException;
	//static int selectFlight(int flightid, String userName) throws ClassNotFoundException,SQLException;	
	}
