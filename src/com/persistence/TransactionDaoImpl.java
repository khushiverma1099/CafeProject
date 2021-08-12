package com.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import com.bean.Addon;
import com.bean.Transaction;
import com.helper.MySqlConnection;

public class TransactionDaoImpl implements TransactionDao{

	@Override
	public boolean insertTransactionRecord(Transaction transaction) throws ClassNotFoundException, SQLException, IOException {
		Connection connection = MySqlConnection.getConnection();;

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO trans(order_id, currdate, currtime, total_price, discount, gst,service_tax, total_bill, customer_name) VALUES(?,?,?,?,?,?,?,?,?)");
		
		
		preparedStatement.setString(1, transaction.getOrderId());
		preparedStatement.setString(2,transaction.getOrderDate());
		preparedStatement.setString(3,transaction.getOrderTime() );
		preparedStatement.setInt(4, transaction.getTotalPrice());
		preparedStatement.setFloat(5, transaction.getDiscount());
		preparedStatement.setFloat(6, transaction.getGst());
		preparedStatement.setFloat(7, transaction.getServiceTax());
		preparedStatement.setFloat(8, transaction.getTotalBill());
		preparedStatement.setString(9, transaction.getCustomer_name());
		
		int rows = preparedStatement.executeUpdate();
		
		if (rows > 0)
			return true;
		
		return false;
	}
	
	@Override
	public Collection<Transaction> getTransactionDetails() throws NullPointerException, ClassNotFoundException, SQLException, IOException {
			
			Connection connection = MySqlConnection.getConnection();
			Collection<Transaction> transactions = new ArrayList<Transaction>();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM trans ORDER BY trans_id DESC LIMIT 1");
			
			ResultSet resultSet = preparedStatement.executeQuery();

			
			while (resultSet.next()) {
				Transaction transaction = new Transaction();
				transaction.setTransaction_id(resultSet.getInt("trans_id"));
				transaction.setOrderId(resultSet.getString("order_id"));
				transaction.setOrderDate(resultSet.getString("currdate"));
				transaction.setOrderTime(resultSet.getString("currtime"));
				transaction.setTotalPrice(resultSet.getInt("total_price"));
				transaction.setDiscount(resultSet.getFloat("discount"));
				transaction.setGst(resultSet.getFloat("gst"));
				transaction.setServiceTax(resultSet.getFloat("service_tax"));
				transaction.setTotalBill(resultSet.getFloat("total_bill"));
				transaction.setCustomer_name(resultSet.getString("customer_name"));

				transactions.add(transaction);
			}
			return transactions;
			

			}		

}
