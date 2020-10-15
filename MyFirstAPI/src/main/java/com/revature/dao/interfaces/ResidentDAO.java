package com.revature.dao.interfaces;

import java.util.List;

import com.revature.models.Resident;

public interface ResidentDAO {
	//A classic DAO has four basic operations:
	//Create or Add, Retrieve or Get, Update, Delete
	
	//POST
	public void createResident(Resident resident);
	
	//GET
	public Resident getResidentById(int id);
	
	//PUT
	public void updateResident(Resident resident);
	
	//DELETE
	public void deleteResident(Resident resident);
	
	//GET
	//Not a part of basic CRUD operations
	public List<Resident> getAllResidents();
}
