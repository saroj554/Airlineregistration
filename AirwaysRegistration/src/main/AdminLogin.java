package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		//System.out.println(name);
		//System.out.println(password);
		
		if(name.equals("admin") && password.equals("admin123"))
		{
			HttpSession session=req.getSession();
			session.setAttribute("name",name);
			System.out.println(session.getAttribute("name"));
			resp.sendRedirect("ViewServlet");
		}
		else
		{
			out.println("login failed");
			
		}
	}
	
	

}
