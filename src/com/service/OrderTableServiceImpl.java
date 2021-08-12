package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bean.OrderTable;
import com.persistence.OrderTableDao;
import com.persistence.OrderTableDaoImpl;

public class OrderTableServiceImpl implements OrderTableService {

	private OrderTableDao orderTableDao = new OrderTableDaoImpl();
	
	@Override
	public String getOrderIdList(int count) throws ClassNotFoundException, SQLException, IOException, IOException {
		String allOrderId="";
		List<Integer> orderIdList = new ArrayList<>();
		orderIdList = orderTableDao.getOrderIdList(count);
		for(int i = 1; i <= orderIdList.size(); i++) {
		 allOrderId += String.valueOf(orderIdList.get(i-1));
	        if(i != orderIdList.size()) {
	        	allOrderId += " ";
	        }
	    }
		return allOrderId;
	}
	
	@Override
	public boolean insertOrderRecord(OrderTable orderTable) throws ClassNotFoundException, SQLException, IOException {
		
		return orderTableDao.insertOrderRecord(orderTable);
	}
	
	@Override
	public Collection<OrderTable> getAllOrderDetails(int count) throws ClassNotFoundException, SQLException, IOException {
		
		return orderTableDao.getAllOrderDetails(count);
	}
}
