package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.bean.OrderTable;

public interface OrderTableDao {
	
	boolean insertOrderRecord(OrderTable orderTable)throws ClassNotFoundException,SQLException, IOException;

	List<Integer> getOrderIdList(int count) throws ClassNotFoundException, SQLException, IOException, IOException;

	Collection<OrderTable> getAllOrderDetails(int count) throws ClassNotFoundException, SQLException, IOException;

}
