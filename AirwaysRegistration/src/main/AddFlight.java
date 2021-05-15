package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDaoImpl;
import model.FlightBean;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		String fname=req.getParameter("flightName");
		String price=req.getParameter("price");
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
		String flightDate=req.getParameter("flightDate");
		
		String totalSeat=req.getParameter("totalSeat");
		String availableSeat=req.getParameter("abvailableSeat");
		FlightBean f=new FlightBean(); 
		System.out.println(fname);
		System.out.println(price);
		System.out.println(source);
		System.out.println(destination);
		System.out.println(flightDate);
		System.out.println(totalSeat);
		System.out.println(availableSeat);
		//System.out.println(source);
		//System.out.println(pr);
		f.setFlightName(fname);
		f.setPrice(price);
		f.setSource(source);
		f.setDestination(destination);
		f.setFlightDate(flightDate);
		f.setTotalSeat(totalSeat);
		f.setAbvailableSeat(availableSeat);
		
		int s=AdminDaoImpl.addflight(f);
		System.out.println(s);
		}
	
	

}
