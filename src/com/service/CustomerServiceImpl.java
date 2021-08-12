package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.Customer;
import com.persistence.CustomerDao;
import com.persistence.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cusDao = new CustomerDaoImpl();
	
	@Override
	public boolean insertCustomer(Customer customer) throws ClassNotFoundException, SQLException, IOException {
		
		return cusDao.insertRecord(customer);
	}
	
	@Override
	public boolean ifPhoneExist(String phone) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return cusDao.ifPhoneExist(phone);
	}
	
	@Override
	public boolean ifPhoneValid(String phone) throws ClassNotFoundException, SQLException, IOException, IOException {
		Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		Matcher match = ptrn.matcher(phone);  
		return (match.find() && match.group().equals(phone));  
	}
	
	@Override
	public String getName(String phone) throws ClassNotFoundException, SQLException, IOException, IOException {
	
		return cusDao.getName(phone);
	}
	
	@Override
	public boolean ifNameValid(String name) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return name == null || name.isEmpty();
	}
}
