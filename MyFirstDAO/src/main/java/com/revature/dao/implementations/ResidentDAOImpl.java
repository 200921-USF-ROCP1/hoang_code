package com.revature.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.interfaces.ResidentDAO;
import com.revature.models.Apartment;
import com.revature.models.Resident;
import com.revature.services.ConnectionService;

public class ResidentDAOImpl implements ResidentDAO {

	Connection connection;
	
	public ResidentDAOImpl() {
		this.connection = ConnectionService.getConnection();
	}
	
	public void createResident(Resident resident) {
		try {
			/* 1. We check if the apartment exists
			 * 2. If we insert that apartment, grab its key
			 * 3. Finally, insert Resident object
			 */
			if(resident.getApartment()!=null) {
				PreparedStatement ps = connection.prepareStatement
						("Select * from apartments where id = ?");
				ps.setInt(1, resident.getApartment().getId());
				
				ResultSet rs = ps.executeQuery();
				if(!rs.next()) {
					//If there's no rows in the result set, create the apartment.
					//apartmentDao.create(resident.getApartment());
					
					PreparedStatement apartmentStatement = connection.prepareStatement
							("Insert into apartments (building_letter,room_number,monthly_rent) values (?,?,?)", 
							Statement.RETURN_GENERATED_KEYS);
					apartmentStatement.setString(1,resident.getApartment().getBuildingLetter());
					apartmentStatement.setInt(2,resident.getApartment().getRoomNumber());
					apartmentStatement.setDouble(3,resident.getApartment().getMonthlyRent());
					apartmentStatement.executeQuery();
					
					//Get the generated keys result set
					ResultSet keys = apartmentStatement.getGeneratedKeys();
					keys.next();
					resident.getApartment().setId(keys.getInt(1));
				}
			}
			PreparedStatement ps = connection.prepareStatement
					("Insert into residents (first_name,last_name,apartment_id) values (?,?,?);");
			ps.setString(1, resident.getFirstName());
			ps.setString(2, resident.getLastName());
			ps.setInt(3, resident.getApartment().getId());
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Resident getResidentById(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM residents WHERE id = ?;");
			ps.setInt(1, id);
			
			//We use executeQuery because it is DQL command
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Resident resident = new Resident();
				resident.setId(rs.getInt("id"));
				resident.setFirstName(rs.getString("first_name"));
				resident.setLastName(rs.getString("last_name"));
				//resident.getApartment().setId(rs.getInt("apartment_id"));
				
				//We need to get the apartment from the database
				//Normally this would go in its own DAO, in a getApartment() method
				//Then I would call apartmentDao.getApartment(rs.getInt("apartment_id"))
				PreparedStatement apartmentStatement = connection.prepareStatement("Select * from apartments where id = ?;");
				apartmentStatement.setInt(1, rs.getInt("apartment_id"));
				
				ResultSet apartmentRs = apartmentStatement.executeQuery();
				if(apartmentRs.next()) {
					Apartment apartment = new Apartment();
					apartment.setId(apartmentRs.getInt("id"));
					apartment.setBuildingLetter(apartmentRs.getString("building_letter"));
					apartment.setRoomNumber(apartmentRs.getInt("room_number"));
					apartment.setMonthlyRent(apartmentRs.getDouble("monthly_rent"));
					
					resident.setApartment(apartment);
				}
				
				return resident;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateResident(Resident resident) {
		try {
			//In order to update the record, we will use UPDATE command
			PreparedStatement ps = connection.prepareStatement
					("UPDATE residents SET first_name = ?, last_name = ?, apartment_id = ? WHERE id = ?;");
			//Because we have four ?s, we use 4 sets
			ps.setString(1, resident.getFirstName());
			ps.setString(2, resident.getLastName());
			ps.setInt(3, resident.getApartment().getId());
			ps.setInt(4, resident.getId());
			
			//We use executeUpdate because it is DML command
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteResident(Resident resident) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM residents WHERE id = ?;");
			ps.setInt(1, resident.getId());
		
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Resident> getAllResidents() {
		List<Resident> residents = new ArrayList<Resident>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM residents LEFT JOIN apartments ON residents.apartment_id = apartments.id;");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Resident resident = new Resident();
				resident.setId(rs.getInt("residents.id"));
				resident.setFirstName(rs.getString("first_name"));
				resident.setLastName(rs.getString("last_name"));
				
				//Get the columns pertaining to the apartment
				//and set the apartment 
				Apartment apartment = new Apartment();
				apartment.setId(rs.getInt("apartments.id"));
				apartment.setBuildingLetter(rs.getString("building_letter"));
				apartment.setRoomNumber(rs.getInt("room_number"));
				apartment.setMonthlyRent(rs.getDouble("monthly_rent"));
					
				resident.setApartment(apartment);
				
				residents.add(resident);
			}
			return residents;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
