package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.bean.Customer;

public interface CustomerService {

	boolean insertCustomer(Customer customer)throws ClassNotFoundException,SQLException, IOException;
	
	boolean ifPhoneExist(String phone)throws ClassNotFoundException,SQLException, IOException, IOException;
	
	boolean ifPhoneValid(String phone) throws ClassNotFoundException, SQLException, IOException, IOException;
	
	String getName(String phone) throws ClassNotFoundException, SQLException, IOException, IOException;
	
	boolean ifNameValid(String name)throws ClassNotFoundException, SQLException, IOException, IOException;
	
}
