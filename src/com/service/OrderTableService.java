package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import com.bean.OrderTable;

public interface OrderTableService {
	
	boolean insertOrderRecord(OrderTable orderTable)throws ClassNotFoundException,SQLException, IOException;
	
	String getOrderIdList(int count) throws ClassNotFoundException, SQLException, IOException, IOException;
	
	Collection<OrderTable> getAllOrderDetails(int count) throws ClassNotFoundException, SQLException, IOException;
	

}
