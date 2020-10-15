package com.revature.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.implementations.ResidentDAOImpl;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Resident;
import com.revature.services.StringUtils;

public class ResidentServlet extends HttpServlet{
	//Object mapper for converting to and from JSON
	private static ObjectMapper mapper = new ObjectMapper();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String[] parts = request.getRequestURI().split("/"); // ["", "MyFirstAPI", "resident",":id"]
		ResidentDAO residentDAO = new ResidentDAOImpl();
		
		try {
			// if user doesn't have access, return unauthorized access.
			if(parts.length == 3) {
				//If there is no given ID, getAll
				//First, we get the actual data
				List<Resident> residents = residentDAO.getAllResidents();
				//Next, we convert our list into JSON and write it to the body
				response.getWriter().println(mapper.writeValueAsString(residents));
			}else if (parts.length == 4) {
				//Otherwise, the last element is an ID
				if(StringUtils.isInteger(parts[3])){
					int id = Integer.parseInt(parts[parts.length-1]);
					Resident resident = residentDAO.getResidentById(id);
					response.getWriter().println(mapper.writeValueAsString(resident));
				}else {
					// do some error handling
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRequestURI(); // /FrontController/MyServlet/1?search=hello&id=9&age=17
		request.getQueryString(); //search=hello&id=9&age=17
		String[] queryParameters = request.getQueryString().split("&");
		
		//Deserialize the body
		try {
			Resident resident = mapper.readValue(request.getReader(), Resident.class);
			
			ResidentDAO residentDAO = new ResidentDAOImpl();
			residentDAO.createResident(resident);
			
			response.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
