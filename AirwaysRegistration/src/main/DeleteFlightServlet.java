package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDaoImpl;

/**
 * Servlet implementation class DeleteFlightServlet
 */
@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
			throws ServletException, IOException {  
		String sid=request.getParameter("flightid");  
		int id=Integer.parseInt(sid);  
		AdminDaoImpl.delete(id);
		response.sendRedirect("ViewServlet");
	}
}
