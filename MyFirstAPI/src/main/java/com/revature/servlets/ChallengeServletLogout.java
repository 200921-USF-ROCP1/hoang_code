package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;

/**
 * Servlet implementation class ChallengeServletLogout
 */
public class ChallengeServletLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User current;
			if((current = (User) request.getSession().getAttribute("current")) == null)
				response.getWriter().println("No one is logged in!");
			else {
				response.getWriter().println(current.getUsername() + " logged out!");
				request.getSession().setAttribute("current", null);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
