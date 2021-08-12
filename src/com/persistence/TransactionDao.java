package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import com.bean.Transaction;

public interface TransactionDao {

	boolean insertTransactionRecord(Transaction transaction)throws ClassNotFoundException,SQLException, IOException;

	Collection<Transaction> getTransactionDetails() throws NullPointerException, ClassNotFoundException, SQLException, IOException;
}
