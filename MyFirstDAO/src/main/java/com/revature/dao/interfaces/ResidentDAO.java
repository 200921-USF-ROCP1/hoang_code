package com.revature.dao.interfaces;

import java.util.List;

import com.revature.models.Resident;

public interface ResidentDAO {
	//A classic DAO has four basic operations:
	//Create or Add, Retrieve or Get, Update, Delete
	
	public void createResident(Resident resident);
	
	public Resident getResidentById(int id);
	
	public void updateResident(Resident resident);
	
	public void deleteResident(Resident resident);
	
	//Not a part of basic CRUD operations
	public List<Resident> getAllResidents();
}
