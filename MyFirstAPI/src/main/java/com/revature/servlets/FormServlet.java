package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		FormModel model = new FormModel();
		
		model.username = request.getParameter("username");
		model.password = request.getParameter("username");
		model.password = request.getParameter("food");
		model.languages = request.getParameterValues("language");
		

		try {
			PrintWriter pw = response.getWriter();
			pw.println("Model Values: <br>" 
									+ "Username: " + model.username 
									+ "<br>Password:" + model.password
									+ "<br>Favorite Food: " + model.food
									+ "<br>Spoken Languages: ");
			for(int i =0;i<model.languages.length;i++)
				pw.println("<br>   " + model.languages[i]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}

class FormModel {
	public String username;
	public String password;
	public String food;
	public String[] languages;
}
