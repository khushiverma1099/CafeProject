package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.bean.Addon;

public interface AddonService {
	
	Collection<Addon> getAllAddonDetails() throws ClassNotFoundException, SQLException, IOException;
	int getaddonPriceList(List<Integer> addonlist) throws ClassNotFoundException, SQLException, IOException, IOException;
	String getaddonNameList(List<Integer> addonlist) throws ClassNotFoundException, SQLException, IOException, IOException;
	boolean ifAddonIdValid(int addonChoice) throws ClassNotFoundException, SQLException, IOException, IOException;
	

}
