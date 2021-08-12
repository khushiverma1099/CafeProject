package com.persistence;

import java.io.IOException;
import java.sql.SQLException;

public interface VoucherDao {

	float getVoucherById(int voucherId)throws ClassNotFoundException, SQLException, IOException, IOException;

	boolean ifVoucherIdValid(int voucherId) throws ClassNotFoundException, SQLException, IOException, IOException;
}
