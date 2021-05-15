package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import service.UserServiceImpl;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		//System.out.println("Signup.doPost()");
		UserBean ub=new UserBean();
		UserServiceImpl us=new UserServiceImpl();
		String name1=request.getParameter("userName");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobileNo");
		String password=request.getParameter("userPass");
	//System.out.println(name1);
	//System.out.println(city);
	//System.out.println(email);
	//System.out.println(mobile);
	//System.out.println(password);
		
		ub.setMobileNo(mobile);
		ub.setUserName(name1);
		ub.setCity(city);
		ub.setEmail(email);
		ub.setPassword(password);
		int rowsCount=0;
	System.out.println(name1);	
	System.out.println(ub.getEmail());
		
//		System.out.println(ub.getMobileNo());
//		System.out.println(ub.getPassword());
//		System.out.println(ub.getUserName());
		
	try 
		{
		rowsCount= us.signupUser(ub);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(rowsCount>0)
		{
			System.out.println("row is"+rowsCount);
	
			out.println("<h1>Sucessfully Resgistered</h1>");
			response.sendRedirect("login.html");
		}
		else 
		{
		out.println("record is not saved");
			
		}
		
	}

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPost(req, resp);	}
	}
