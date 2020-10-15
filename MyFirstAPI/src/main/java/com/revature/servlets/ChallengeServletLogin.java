package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.implementations.ResidentDAOImpl;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Resident;
import com.revature.models.User;
import com.revature.services.StringUtils;

/**
 * Servlet implementation class ChallengeServletLogin
 */
public class ChallengeServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper = new ObjectMapper();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User current;
			if((current = (User) request.getSession().getAttribute("current")) == null)
				response.getWriter().println("Invalid credentials.");
			else {
				response.getWriter().println(current.getUsername() + " is logged in!");
				response.getWriter().println("Password stored: " + current.getPassword());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User dummy = new User("username","password");
		try {
			JsonNode jsonNode = mapper.readTree(request.getReader());
			User user = new User(jsonNode.get("username").asText(), jsonNode.get("password").asText());
			if(	user.getUsername().equals(dummy.getUsername()) &&
				user.getPassword().equals(dummy.getPassword())) {
				request.getSession().setAttribute("current", new User(user.getUsername()));
				response.setStatus(201);
			}else
				response.setStatus(400);
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
}
