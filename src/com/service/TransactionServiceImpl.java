package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import com.bean.Transaction;
import com.persistence.TransactionDao;
import com.persistence.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService {
	
	private TransactionDao transactionDao = new TransactionDaoImpl();
	
	@Override
	public boolean insertTransactionRecord(Transaction transaction) throws ClassNotFoundException, SQLException, IOException {
		
		return transactionDao.insertTransactionRecord(transaction);
	}
	
	
	@Override
	public float[] calculateBill(int total, float voucher)throws ClassNotFoundException, SQLException, IOException, IOException {
	 
			float discount = (float)(voucher/100)*(total);
			float netValue = total - ((float)(voucher/100)*(total)); 
			float gst =  ((float)18/100)* netValue;
			float serviceTax = ((float)8/100)* netValue;
			float totalBill = netValue + gst + serviceTax;
			float ans[]  = {gst,serviceTax, totalBill, discount};
			return ans;
	}	
	
	@Override
	public Collection<Transaction> getTransactionDetails() throws NullPointerException, ClassNotFoundException, SQLException, IOException {
		
		return transactionDao.getTransactionDetails();
	}

}
