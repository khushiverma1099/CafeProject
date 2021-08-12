package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.DriverManager;

import com.bean.Addon;
import com.bean.Coffee;
import com.bean.Customer;
import com.helper.MySqlConnection;



public class CustomerDaoImpl implements CustomerDao {
	
	@Override
	public boolean ifPhoneExist(String phone)throws ClassNotFoundException, SQLException, IOException, IOException {
		Connection connection = MySqlConnection.getConnection();;
		PreparedStatement preparedStatement = connection.prepareStatement("select customer_name from customer where phone_no = ?");
		
		preparedStatement.setString(1, phone);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			String phoneno = resultSet.getString(1);
			if(phoneno != null)
			return true;
		}
					
		return false;

	}

	
	
		@Override
		public String getName(String phone) throws ClassNotFoundException, SQLException, IOException, IOException {
			Connection connection = MySqlConnection.getConnection();;
			String Name = null;
			PreparedStatement preparedStatement = connection.prepareStatement("select customer_name from customer where phone_no = ?");
			
			preparedStatement.setString(1, phone);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
			Name = resultSet.getString(1);}
			return Name;

		}
	

	@Override
	public boolean insertRecord(Customer customer)
			throws ClassNotFoundException, SQLException, IOException, IOException {
			Connection connection = MySqlConnection.getConnection();;

			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer(customer_name,phone_no) VALUES(?,?)");

			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPhone());

			int rows = preparedStatement.executeUpdate();
			
			if (rows > 0)
				return true;
			
			return false;
		}
	
}	
	







