package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.Addon;
import com.bean.Coffee;
import com.bean.Customer;
import com.bean.OrderTable;
import com.bean.Transaction;
import com.helper.CustomerInputOutput;
import com.persistence.AddonDao;
import com.persistence.AddonDaoImpl;
import com.persistence.CoffeeDao;
import com.persistence.CoffeeDaoImpl;
import com.persistence.CustomerDao;
import com.persistence.CustomerDaoImpl;
import com.persistence.OrderTableDao;
import com.persistence.OrderTableDaoImpl;
import com.persistence.TransactionDao;
import com.persistence.TransactionDaoImpl;
import com.persistence.VoucherDao;
import com.persistence.VoucherDaoImpl;


public class CoffeeServiceImpl implements CoffeeService {
	
	private CoffeeDao coffeeDao = new CoffeeDaoImpl();
	
	
	@Override
	public int getRecordById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return coffeeDao.getCoffeeById(coffeeId);
	}
	
	@Override
	public String getCoffeeNameById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return coffeeDao.getCoffeeNameById(coffeeId);
	}
	
	@Override
	public String getCoffeeSizeById(int coffeeId) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return coffeeDao.getCoffeeSizeById(coffeeId);
	}
	
	@Override
	public Collection<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException, IOException {
		
		return coffeeDao.getAllCoffeeDetails();
	}
	
	@Override
	public boolean ifCoffeeIdValid(int coffeeChoice) throws ClassNotFoundException, SQLException, IOException, IOException {

		return coffeeDao.ifCoffeeIdValid(coffeeChoice);
	}

}