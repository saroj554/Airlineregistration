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

import dao.AdminDaoImpl;
import model.FlightBean;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();

		List<FlightBean> list=AdminDaoImpl.getAllFlight();


		out.println("<h1>Flight Details</h1>");
		out.println("<style>table{background-color:#62c79c; border-radius:5px;}"
				+ "body{background-color:#6abf9b;}</style>"
				+ "a{text-decoration:none;}");
		out.print("<table border='1' width='100%'");  
		out.print("<tr><th>FlightId</th><th>FlightName</th><th>FlightPrice</th><th>FlightSource</th><th>FlightDestinatio</th><th>FlightDate</th><th>TotalSeat</th><th>AvailableSeat</th><th>Edit</th><th>Delete</th></tr>");  
	
//		HttpSession session=req.getSession();
//		session.getAttribute("name");
//		System.out.println(session.getAttribute("name"));
		for(FlightBean f:list){

			System.out.println(f.getFlightName());
			//out.println(f.getFlightName());

			out.print("<tr><td>"+f.getFlightid()+"</td><td>"+f.getFlightName()+"</td><td>"+f.getPrice()+"</td><td>"+f.getSource()+"</td><td>"+f.getDestination()+"</td><td>"+f.getFlightDate()+"</td><td>"+f.getTotalSeat()+"</td><td>"+f.getAbvailableSeat()+"</td><td><a href='EditServlet?flightid="+f.getFlightid()+"'>Edit</a></td><<td><a href='DeleteFlightServlet?flightid="+f.getFlightid()+"'>Delete</a></td></tr>");
		}  
		out.print("</table>");
		
		out.println("<a href='AddFlight.html'>AddNewFlight</a>");

	}


}
