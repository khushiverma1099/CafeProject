package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import com.bean.Addon;
import com.bean.Coffee;
import com.bean.Customer;

public interface CustomerDao {

	
	boolean insertRecord(Customer Customer)throws ClassNotFoundException,SQLException, IOException, IOException;

	boolean ifPhoneExist(String phone)throws ClassNotFoundException,SQLException, IOException, IOException;

	String getName(String phone) throws ClassNotFoundException, SQLException, IOException, IOException;


}
