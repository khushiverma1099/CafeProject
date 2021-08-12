package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bean.Addon;
import com.bean.Customer;
import com.helper.MySqlConnection;

public class AddonDaoImpl implements AddonDao{

	@Override
	public Collection<Addon> getAllAddonDetails() throws ClassNotFoundException, SQLException, IOException {
			
			Connection connection = MySqlConnection.getConnection();
			Collection<Addon> coffees = new ArrayList<Addon>();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM addon");
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Addon addon = new Addon();
				addon.setAddonId(resultSet.getInt("addon_id"));
				addon.setAddonName(resultSet.getString("addon_name"));
				addon.setPrice(resultSet.getInt("addon_price"));
				

				coffees.add(addon);
			}

			
			return coffees;
			

		}
	@Override
	
	public List<Integer> getaddonPriceList(List<Integer> addonlist) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		Connection connection = MySqlConnection.getConnection();
		List<Integer> addonPriceList = new ArrayList<>();
		for(int cf: addonlist) {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT addon_price FROM addon where addon_id=?");
		preparedStatement.setInt(1, cf);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			addonPriceList.add(resultSet.getInt("addon_price"));
			}
		}
		return addonPriceList ;
	}

	
	@Override
	
	public List<String> getaddonNameList(List<Integer> addonlist) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		Connection connection = MySqlConnection.getConnection();
		List<String> addonNameList = new ArrayList<>();
		for(int cf: addonlist) {
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT addon_name FROM addon where addon_id=?");
		preparedStatement.setInt(1, cf);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			addonNameList.add(resultSet.getString("addon_name"));
			}
		}
		return addonNameList ;
	}

	
	@Override
	public boolean ifAddonIdValid(int addonChoice)throws ClassNotFoundException, SQLException, IOException, IOException {
	Connection connection = MySqlConnection.getConnection();;
	PreparedStatement preparedStatement = connection.prepareStatement("select count(addon_id) from addon where addon_id = ?");
	
	preparedStatement.setInt(1, addonChoice);
	
	ResultSet resultSet = preparedStatement.executeQuery();
	
	if (resultSet.next()) {
		int count = resultSet.getInt(1);
		if(count != 0)
		return true;
	}
				
	return false;

	}

}
