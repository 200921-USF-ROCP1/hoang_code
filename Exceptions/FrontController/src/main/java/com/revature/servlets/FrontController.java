package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * A Front Controller is a singular servlet that acts as a router
 * for all requests.
 * Technically, you could get away with only having this one servlet
 * and handling requests with your own services or classes.
 * You could also route requests to other servlets if you want to.
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();	// /FrontController/MyServlets/1
		String[] parts = path.split("/");		// ["","FrontController","MyServlets","1"]
		
		// /cars/:id, /users/:id. I want to call CarDAOImpl.get(id) for one, and UserDAOImpl.get(id) for the other
		switch(parts[2]) {
		case "car":
			//I could call a CarService here and pass request and response to deal with them there.
			//I could also get the data from the request and pass them to my DAO here.
			break;
		case "user":
			break;
		}
		
		//To path match /car/1: /car/*.  What if I wanted car/1/version/1. Url path? car/1/version/*
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
