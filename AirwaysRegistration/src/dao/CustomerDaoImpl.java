package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.FlightBean;
import util.DbuUility;

public class CustomerDaoImpl  implements CustomerDao{

	public int ticketBooking(Booking b) throws ClassNotFoundException,SQLException
	{
		//		System.out.println(b.getPassengerName());
		//		System.out.println(b.getPassengerAge());
		//		System.out.println(b.getPassengerMobile());
		//		System.out.println(b.getPassengerEmail());

		int rowsCount=0;
		try
		{
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO passenger(userid,flightid,passenger_name, passenger_age, passenger_mobile, passenger_email,seat) VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1,b.getUserid());
			ps.setInt(2, b.getFlightid());
			ps.setString(3,b.getPassengerName());
			ps.setString(4, b.getPassengerAge());
			ps.setString(5,b.getPassengerMobile());
			ps.setString(6,b.getPassengerEmail());
			ps.setString(7,b.getNumberOfSeat());
			rowsCount= ps.executeUpdate();
			System.out.println(b.getPassengerAge());
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbuUility.getDbConnectionClose();	
		}
		return rowsCount;
	}
	public	List<FlightBean> viewJourney() throws ClassNotFoundException,SQLException
	{
		List<FlightBean> list=new ArrayList<FlightBean>();
		try {
			Connection con=DbuUility.getDbConnection();
			PreparedStatement ps=con.prepareStatement("select * from flight");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FlightBean f=new FlightBean();
				f.setFlightid(rs.getInt(1));
				f.setFlightName(rs.getString(2));
				f.setPrice(rs.getString(3));
				f.setSource(rs.getString(4));
				f.setDestination(rs.getString(5));
				f.setFlightDate(rs.getString(6));
				f.setTotalSeat(rs.getString(7));
				f.setAbvailableSeat(rs.getString(8));
				list.add(f);
			}


		} catch(Exception e) { System.out.println(e); }
		System.out.println(list);
		return list;

	}
	

	public	List<Booking> viewPassenger() throws ClassNotFoundException,SQLException
	{

		List<Booking> list=new ArrayList<Booking>();

		try {
			Connection con=DbuUility.getDbConnection();
			PreparedStatement ps=con.prepareStatement("select passenger_name, passenger_age, passenger_mobile, passenger_email, seat from passenger");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Booking b=new Booking();
				b.setPassengerName(rs.getString(1));
				b.setPassengerAge(rs.getString(2));
				b.setPassengerEmail(rs.getString(3));
				b.setPassengerMobile(rs.getString(4));
				b.setNumberOfSeat(rs.getString(5));
				list.add(b);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;

	}
}

