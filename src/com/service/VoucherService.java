package com.service;

import java.io.IOException;
import java.sql.SQLException;

public interface VoucherService {

	float getVoucherById(int ifVoucher)throws ClassNotFoundException,SQLException, IOException, IOException;
	
	boolean ifVoucherIdValid(int voucherChoice) throws ClassNotFoundException, SQLException, IOException, IOException;
	
}
