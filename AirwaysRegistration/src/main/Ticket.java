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
 * Servlet implementation class Ticket
 */
@WebServlet("/Ticket")
public class Ticket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=resp.getWriter();
		
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"body {\r\n" + 
				"	background-color: #ececec;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"form {\r\n" + 
				"	display: flex;\r\n" + 
				"	flex-direction: column;\r\n" + 
				"	width: 50vw;\r\n" + 
				"	position: fixed;\r\n" + 
				"	top: 70px;\r\n" + 
				"	left: 25vw;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".textArea {\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"table {\r\n" + 
				"	padding: 20px;\r\n" + 
				"	background-color:#e4dbff;\r\n" + 
				"	border-radius: 10px;\r\n" + 
				"	box-shadow: -5px 10px 8px 	#d3f8ff;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h2 {\r\n" + 
				"	width: 100%;\r\n" + 
				"	text-align: center;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".add {\r\n" + 
				"	margin-top: 20px;\r\n" + 
				"	border-radius: 5px;\r\n" + 
				"	background-color: #e1d8c7;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<form action=\"TicketBooking\" method=\"post\">\r\n" + 
				"	<h2>Booking section</h2>\r\n" + 
				"		<table>\r\n" + 
				"		\r\n" + 
				"		<tr>\r\n" + 
				"				<td><h3>Enter number of seats:</h3></td>\r\n" + 
				"				<td class=\"textArea\"><input type=\"number\" name=\"noOfseat\" required></td>\r\n" + 
				"			</tr>\r\n" + 
				"			\r\n" + 
				"			<tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><h3>Enter your name:</h3></td>\r\n" + 
				"				<td class=\"textArea\"><input type=\"text\" name=\"pname\" required></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><h3>Enter your age:</h3></td>\r\n" + 
				"				<td class=\"textArea\"><input type=\"number\" name=\"page\" required></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><h3>Enter your mobile no:</h3></td>\r\n" + 
				"				<td class=\"textArea\"><input type=\"number\" name=\"pmobile\"\r\n" + 
				"					required></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td><h3>Enter your email id:</h3></td>\r\n" + 
				"				<td class=\"textArea\"><input type=\"email\" name=\"pemail\" required></td>\r\n" + 
				"			</tr>\r\n" + 
				"\r\n" + 
				"		</table>\r\n" + 
				"		<button type=\"submit\" class=\"add\">Add</button>\r\n" + 
				"\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
//		HttpSession hs=req.getSession();
//		int flightId=(int) hs.getAttribute("flightId");
//		System.out.println(flightId);
//		int userid=(int) hs.getAttribute("userid");
//		System.out.println(userid);
	}
	
	
}