package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.FlightBean;
import util.DbuUility;

public class AdminDaoImpl {

	public static int update(FlightBean f) throws ClassNotFoundException, SQLException {
		int status = 0;
		try {
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement(
					"update flight set flightName=?,price=?,source=?,destination=?,flightDate=?,totalSeat=?,abvailableSeat=? where flightid=?");
			ps.setString(1, f.getFlightName());
			ps.setString(2, f.getPrice());
			ps.setString(3, f.getSource());
			ps.setString(4, f.getDestination());
			ps.setString(5, f.getFlightDate());
			ps.setString(6, f.getTotalSeat());
			ps.setString(7, f.getAbvailableSeat());
			ps.setInt(8, f.getFlightid());
			status = ps.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	public static int delete(int flightid) {
		int status = 0;
		try {
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement("delete from flight where flightid=?");
			ps.setInt(1, flightid);

			status = ps.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return status;
	}

	public static FlightBean getFlightById(int flightid) {
		FlightBean f = new FlightBean();

		try {
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement("select * from flight where flightid=?");
			ps.setInt(1, flightid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f.setFlightid(rs.getInt(1));
				f.setFlightName(rs.getString(2));
				f.setPrice(rs.getString(3));
				f.setSource(rs.getString(4));
				f.setDestination(rs.getString(5));
				f.setFlightDate(rs.getString(6));
				f.setTotalSeat(rs.getString(7));
				f.setAbvailableSeat(rs.getString(8));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return f;
	}

	public static List<FlightBean> getAllFlight() {
		List<FlightBean> list = new ArrayList<FlightBean>();
		try {
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement("select * from flight");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FlightBean f = new FlightBean();
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

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(list);
		return list;
	}

	public static int addflight(FlightBean f) {
		int rowsCount = 0;
		try {
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO flight(flightName, price, source, destination, flightDate, totalSeat, abvailableSeat) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, f.getFlightName());
			ps.setString(2, f.getPrice());
			ps.setString(3, f.getSource());
			ps.setString(4, f.getDestination());
			ps.setString(5, f.getFlightDate());
			ps.setString(6, f.getTotalSeat());
			ps.setString(7, f.getAbvailableSeat());
			rowsCount = ps.executeUpdate();
		} catch (Exception e) {
		}

		return rowsCount;
	}

	public void updateSeatById(int flightid, String numOfSeat) {
		int userSeats = Integer.parseInt(numOfSeat);
		String seats = "";
		String rSeat = "";
		try {
			String query1 = "select abvailableSeat from flight where flightid =" + flightid + " ";
			Connection con = DbuUility.getDbConnection();
			PreparedStatement ps = con.prepareStatement(query1);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				seats = rs.getString("abvailableSeat");
				int availableSeats = Integer.parseInt(seats);
				int remainingSeats = availableSeats - userSeats;
				System.out.println(remainingSeats);
				rSeat = Integer.toString(remainingSeats);
				
			}
			String query2 = "update flight set abvailableSeat ='"+rSeat+"' where flightid = "+flightid+" ";
			Statement statement = con.createStatement();
			statement.executeUpdate(query2);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
