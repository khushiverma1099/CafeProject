package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.helper.MySqlConnection;
import com.service.CoffeeServiceImpl;

public class VoucherDaoImpl implements VoucherDao{

	@Override
	public float getVoucherById(int voucherId) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		Connection connection = MySqlConnection.getConnection();
		float discount = 0.0f;
		
		PreparedStatement preparedStatement = connection.prepareStatement("select discount_per from voucher where voucher_id = ? and validity >= current_date()");
		preparedStatement.setInt(1, voucherId);
		
		
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			discount=(resultSet.getFloat("discount_per"));
			}
		return discount ;
	}

	@Override
	public boolean ifVoucherIdValid(int voucherId)throws ClassNotFoundException, SQLException, IOException, IOException {
		Connection connection = MySqlConnection.getConnection();;
		PreparedStatement preparedStatement = connection.prepareStatement("select count(voucher_id) from voucher where voucher_id = ?");
		
		preparedStatement.setInt(1, voucherId);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			int count = resultSet.getInt(1);
			if(count != 0)
			return true;
		}
					
		return false;

	}
}
