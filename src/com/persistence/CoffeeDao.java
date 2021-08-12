package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bean.Addon;
import com.bean.Coffee;


public interface CoffeeDao {

	
	Collection<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException, IOException;
	int getCoffeeById(int coffeeId)throws ClassNotFoundException, SQLException, IOException, IOException;
	List<Integer> getcoffeePriceList(List<Integer> coffeelist)throws ClassNotFoundException, SQLException, IOException, IOException;
	String getCoffeeNameById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException;
	String getCoffeeSizeById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException;
	boolean ifCoffeeIdValid(int coffeeChoice) throws ClassNotFoundException, SQLException, IOException, IOException;
	
}
