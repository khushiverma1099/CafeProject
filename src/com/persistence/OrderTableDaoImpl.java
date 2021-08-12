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
import com.bean.OrderTable;
import com.helper.MySqlConnection;

public class OrderTableDaoImpl implements OrderTableDao {

	@Override
	public boolean insertOrderRecord(OrderTable orderTable) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = MySqlConnection.getConnection();;

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO order_table(coffee_name, size, price, addon_name, addon_price , total_price) VALUES(?,?,?,?,?,?)");

		preparedStatement.setString(1, orderTable.getCoffeeName());
		preparedStatement.setString(2, orderTable.getSize());
		preparedStatement.setInt(3, orderTable.getPrice());
		preparedStatement.setString(4, orderTable.getAddonName());
		preparedStatement.setInt(5, orderTable.getAddonPrice());
		preparedStatement.setInt(6, orderTable.getTotalPrice());

		int rows = preparedStatement.executeUpdate();
		
		if (rows > 0)
			return true;
		
		return false;
	}
	
	@Override
	public List<Integer> getOrderIdList(int count) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		Connection connection = MySqlConnection.getConnection();
		List<Integer> orderIdList = new ArrayList<>();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT orderid FROM  order_table ORDER BY orderid DESC LIMIT ?");
		preparedStatement.setInt(1, count);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			orderIdList.add(resultSet.getInt("orderid"));
			}
		return orderIdList ;
	}

	
	@Override
	public Collection<OrderTable> getAllOrderDetails(int count) throws ClassNotFoundException, SQLException, IOException {
		
		Connection connection = MySqlConnection.getConnection();
		Collection<OrderTable> ordersTable = new ArrayList<OrderTable>();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM order_table ORDER BY orderid DESC LIMIT ?");
		preparedStatement.setInt(1, count);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			OrderTable orderTable = new OrderTable();
			
			orderTable.setOrderId(resultSet.getInt("orderid"));
			orderTable.setCoffeeName(resultSet.getString("coffee_name"));
			orderTable.setSize(resultSet.getString("size"));
			orderTable.setPrice(resultSet.getInt("price"));
			orderTable.setAddonName(resultSet.getString("addon_name"));
			orderTable.setAddonPrice(resultSet.getInt("addon_price"));
			orderTable.setTotalPrice(resultSet.getInt("total_price"));
			
			ordersTable.add(orderTable);
		}
		return ordersTable;

	}




}
