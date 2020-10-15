package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.dao.implementations.ResidentDAOImpl;
import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Resident;
import com.revature.services.ConnectionService;

public class App {
	public static void main(String[] args) {		
		try {	
			Class.forName("org.postgresql.Driver");
			ResidentDAO residentDAO = new ResidentDAOImpl();
			Resident res = new Resident();
			res.setFirstName("Ressy");
			res.setLastName("Ression");
			//res.setApartmentId(1);
			
			residentDAO.createResident(res);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionService.closeConnection();
		}
	}
}
