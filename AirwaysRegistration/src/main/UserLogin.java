package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.UserBean;
import service.UserServiceImpl;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(UserLogin.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Inside UserLogin servlet class");
		PrintWriter out = response.getWriter();
		UserBean ub1 = new UserBean();
		UserServiceImpl usi = new UserServiceImpl();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPass");

		int flag = 0;

		ub1.setUserName(userName);
		ub1.setPassword(userPassword);
		try {
			LOGGER.info("Calling loginUser method of service class.");
			flag = usi.loginUser(ub1);
		} catch (ClassNotFoundException|SQLException e) {
			LOGGER.error("Error generated while calling loginUser method.");
			e.printStackTrace();
		}
		if (flag != 0) {
			LOGGER.info("User login successful.");
			HttpSession session = request.getSession();
			session.setAttribute("userid", flag);

			response.sendRedirect("UserDashboard.html");
			System.out.println("login suces");

		} else {
			response.sendRedirect("login.html");
		}

	}

}
