package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import com.bean.Transaction;

public interface TransactionService {

	float[] calculateBill(int total, float voucher) throws ClassNotFoundException, SQLException, IOException, IOException;
	
	boolean insertTransactionRecord(Transaction transaction) throws ClassNotFoundException, SQLException, IOException;
	
	Collection<Transaction> getTransactionDetails() throws NullPointerException, ClassNotFoundException, SQLException, IOException;
	
}
