package main;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDaoImpl;
import model.FlightBean;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String flightid=req.getParameter("flightid");
		int id=Integer.parseInt(flightid);
		String flightName=req.getParameter("flightName");
		String price=req.getParameter("price");
		
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
		String flightDate=req.getParameter("flightDate");
		
		String totalSeat=req.getParameter("totalSeat");
		
		String abvailableSeat=req.getParameter("abvailableSeat");
		
		
		FlightBean f=new FlightBean();
		f.setFlightid(id);
		f.setFlightName(flightName);
		f.setPrice(price);
		f.setSource(source);
		f.setDestination(destination);
		f.setFlightDate(flightDate);
		f.setTotalSeat(totalSeat);
		f.setAbvailableSeat(abvailableSeat);
		
		System.out.println(f.getFlightName());
		int status = 0;
		try {
			status = AdminDaoImpl.update(f);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		if(status>0)
		{
			resp.sendRedirect("ViewServlet");
		}
		else
		{
			
		}
		
	}
}
