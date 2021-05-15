package service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import model.Booking;
import model.FlightBean;

public class CustomerServiceImpl implements CustomerService {
	static final Logger LOGGER=Logger.getLogger(CustomerServiceImpl.class);
	public	int ticketBooking(Booking b) throws ClassNotFoundException,SQLException
	{
		int rowsCount=0;
		try 
		{
			LOGGER.info("Calling CustomerDaoImpl method");
			CustomerDao cd=new CustomerDaoImpl();
			rowsCount= cd.ticketBooking(b);
		}
		catch(Exception e) 
		{
			LOGGER.error("Booking is not allowed");
			System.out.println(e);	
		}
		return rowsCount;
	}
	public	List<FlightBean> viewJourney() throws ClassNotFoundException,SQLException
	{
		List<FlightBean> list=null;
		try 
		{
	CustomerDao cd=new CustomerDaoImpl();
			list=cd.viewJourney();
		}
		catch(Exception e) 
		{
			LOGGER.error("Something wents wrong"+e);
			System.out.println(e);
		}

		return list;
	}
}
