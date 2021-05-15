package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import model.Booking;
@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		List<Booking> list = null;
		try {
			list = cdi.viewPassenger();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		int userId = Integer.parseInt(request.getParameter("userId"));
		if(userId == 0) 
		{
			response.sendRedirect("UserDashboard.html");
			
		}
		out.println("<h1>Passenger Details</h1>");
		out.println("<style>table{color:}</style>");
		out.print("<table border='1' width='70%'");  
		out.print("<tr><th>PassengerName</th><th>PassengerAge</th><th>PassengerEmail</th><th>PassengerMobile</th><th>NumberOfSeat</th></tr>");  
		for(Booking b:list){

			System.out.println(b.getPassengerName());
			System.out.println(userId);
			out.print("<tr><td>"+b.getPassengerName()+"</td><td>"+b.getPassengerAge()+"</td><td>"+b.getPassengerEmail()+"</td><td>"+b.getPassengerMobile()+"</td><td>"+b.getNumberOfSeat()+"</td> <<td>");
		}  
		out.print("</table>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
