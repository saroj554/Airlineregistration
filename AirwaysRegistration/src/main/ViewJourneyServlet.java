
package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.AdminDaoImpl;
import model.FlightBean;


@WebServlet("/ViewJourneyServlet")
public class ViewJourneyServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(ViewJourneyServlet.class);
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out=resp.getWriter();
		LOGGER.info("calling Flight details method");
		List<FlightBean> list=AdminDaoImpl.getAllFlight();

		HttpSession hs=req.getSession();
		int userName=(int)hs.getAttribute("userid");
		System.out.println(userName);
		//		hs.removeAttribute("username");
		if(userName == 0) 
		{
			resp.sendRedirect("UserDashboard.html");

		}
		out.println("<h1>Flight Details</h1>");
		out.println("<style>table{color:#b11dde  }</style>");
		out.print("<table border='1' width='70%'");  
		out.print("<tr><th>FlightId</th><th>FlightName</th><th>FlightPrice</th><th>FlightSource</th><th>FlightDestinatio</th><th>FlightDate</th><th>TotalSeat</th><th>AvailableSeat</th><th>Select</th><th>Passengers</th></tr>");  
		for(FlightBean f:list){

			System.out.println(f.getFlightName());
			//out.println(f.getFlightName());
			int flightId = f.getFlightid();
			hs.setAttribute("flightId", flightId);
			System.out.println(flightId);
			out.print("<tr><td>"+f.getFlightid()+"</td><td>"+f.getFlightName()+"</td><td>"+f.getPrice()+"</td><td>"+f.getSource()+"</td><td>"+f.getDestination()+"</td><td>"+f.getFlightDate()+"</td><td>"+f.getTotalSeat()+"</td><td>"+f.getAbvailableSeat()+"</td><td><a href='TicketBooking.html'>Booking</a></td>"+"<td><a href=\"ViewDetails?userId="+userName+"\">View</a></td>");
		}  
		out.print("</table>");

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req,resp);
	}
}
