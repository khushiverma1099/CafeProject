package com.persistence;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.bean.Addon;
import com.bean.Customer;

public interface AddonDao {

	Collection<Addon> getAllAddonDetails() throws ClassNotFoundException, SQLException, IOException;

	List<Integer> getaddonPriceList(List<Integer> addonlist)throws ClassNotFoundException, SQLException, IOException, IOException;

	List<String> getaddonNameList(List<Integer> addonlist)
			throws ClassNotFoundException, SQLException, IOException, IOException;

	boolean ifAddonIdValid(int addonChoice) throws ClassNotFoundException, SQLException, IOException, IOException;

}
