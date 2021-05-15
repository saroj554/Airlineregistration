package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/userDashboard")
public class UserOptionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final Logger LOGGER=Logger.getLogger(UserOptionServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String choice = request.getParameter("airline");
		if (choice.equals("booking") && (request.getParameter("confirm") != null)) {
			LOGGER.info("Calling servlet to redirect to journey details:");
			request.getRequestDispatcher("ViewJourneyServlet").forward(request, response);
		}
		if (choice.equals("cancel") && (request.getParameter("confirm") != null)) {
			request.getRequestDispatcher("cancelTicket.html").forward(request, response);
		}

		if (choice.equals("logout") && (request.getParameter("confirm") != null)) {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
