package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.AdminDaoImpl;
import dao.CustomerDaoImpl;
import model.Booking;
import service.CustomerServiceImpl;

@WebServlet("/TicketBooking")
public class BookingServlet extends HttpServlet {

	static final Logger LOGGER = Logger.getLogger(BookingServlet.class);
	private static final long serialVersionUID = 1L;
	private static AdminDaoImpl adi = new AdminDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// System.out.println("Signup.doPost()");
		Booking b = new Booking();
		CustomerServiceImpl csi = new CustomerServiceImpl();
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		String name1 = request.getParameter("pname");
		String age = request.getParameter("page");
		String email = request.getParameter("pemail");
		String mobile = request.getParameter("pmobile");
		String seat = request.getParameter("noOfseat");
//		System.out.println(name1);
//		System.out.println(age);
//		System.out.println(email);
//		System.out.println(mobile);
		// System.out.println(password);
		HttpSession session = request.getSession();
		session.setAttribute("passenger_name", name1);
		int fid = (int) session.getAttribute("flightId");
		System.out.println(fid);
		int userid = (int) session.getAttribute("userid");
		System.out.println(userid);
		b.setPassengerName(name1);
		b.setPassengerAge(age);
		b.setPassengerEmail(email);
		b.setPassengerMobile(mobile);
		b.setFlightid(fid);
		b.setUserid(userid);
		b.setNumberOfSeat(seat);
		int rowsCount = 0;

		try {
			LOGGER.info("Inside the Customer Service calling ticket booking method");
			rowsCount = csi.ticketBooking(b);
			if (rowsCount > 0) {
				adi.updateSeatById(fid, seat);
				request.getRequestDispatcher("ViewJourneyServlet").forward(request, response);
			} else {
				out.println("<h3>Details is not saved</h3>");

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
