package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.AsynchronousServerSocketChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;

public class ChallengeFormServlet extends HttpServlet {
	
	private static ObjectMapper mapper = new ObjectMapper();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = (User) request.getSession().getAttribute("registeredUser");
			if(user == null)
				DisplayHTML(response);
			else {
				response.getWriter().println("User Created: <br>" 
						+ "Username: " + user.getUsername() 
						+ "<br>Password:" + user.getPassword());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().setAttribute("registeredUser", new User(request.getParameter("username"),request.getParameter("password")));
			doGet(request, response);
			response.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
	}
	static void DisplayHTML(HttpServletResponse response) {
		try {
			response.getWriter().println("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"utf-8\" />\r\n"
					+ "    <title></title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<form method=\"POST\" action=\"http://localhost:8080/MyFirstAPI/register\">\r\n"
					+ "		Username:<input type=\"text\" name=\"username\"/><br>\r\n"
					+ "		Password:<input type=\"password\" name=\"password\"/><br>\r\n"
					+ "		<br>\r\n"
					+ "		<input type=\"submit\" value=\"Register\">\r\n"
					+ "	</form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
