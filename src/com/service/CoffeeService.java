package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import com.bean.Coffee;



public interface CoffeeService {

	Collection<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException, IOException;

	int getRecordById(int coffeeId)throws ClassNotFoundException,SQLException, IOException, IOException;
	
	String getCoffeeSizeById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException;
	
	String getCoffeeNameById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException;
	
	boolean ifCoffeeIdValid(int coffeeChoice) throws ClassNotFoundException, SQLException, IOException, IOException;

}