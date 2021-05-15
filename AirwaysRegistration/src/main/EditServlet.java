package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDaoImpl;
import model.FlightBean;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		out.println("<h1>Update User</h1>");
		
		String sid=req.getParameter("flightid");
		int id=Integer.parseInt(sid);

		FlightBean f=AdminDaoImpl.getFlightById(id);
		
		 out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='flightid' value='"+f.getFlightid()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='flightName' value='"+f.getFlightName()+"'/></td></tr>");  
	        out.print("<tr><td>Price:</td><td><input type='number' name='price' value='"+f.getPrice()+"'/></td></tr>");
	        out.print("<tr><td>source:</td><td><input type='text' name='source' value='"+f.getSource()+"'/></td></tr>");
	        out.print("<tr><td>destination:</td><td><input type='text' name='destination' value='"+f.getDestination()+"'/></td></tr>");
	        out.print("<tr><td>flight date:</td><td><input type='date' name='flightDate' value='"+f.getFlightDate()+"'/></td></tr>");
	        out.print("<tr><td>Total seat:</td><td><input type='number' name='totalSeat' value='"+f.getTotalSeat()+"'/></td></tr>");          
	        out.print("<tr><td>TAvailable seat:</td><td><input type='number' name='abvailableSeat' value='"+f.getAbvailableSeat()+"'/></td></tr>");
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	}
	
	

}
