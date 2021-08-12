package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.persistence.VoucherDao;
import com.persistence.VoucherDaoImpl;

public class VoucherServiceImpl implements VoucherService {

	private VoucherDao voucherDao = new VoucherDaoImpl();
	
	
	@Override
	public float getVoucherById(int voucherId) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return voucherDao.getVoucherById(voucherId);
	}
	
	@Override
	
	public boolean ifVoucherIdValid(int voucherChoice) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return voucherDao.ifVoucherIdValid(voucherChoice);
	}
}
