package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Exception e = (Exception) request.getAttribute("javax.servlet.error.exception");
			response.getWriter().println(e.getMessage());
			StackTraceElement[] elements = e.getStackTrace();
			for(int i=0;i<elements.length;i++)
				response.getWriter().println(elements[i].toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
