package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bean.Addon;
import com.persistence.AddonDao;
import com.persistence.AddonDaoImpl;

public class AddonServiceImpl implements AddonService {
	
	private AddonDao addonDao = new AddonDaoImpl();
	@Override
	public Collection<Addon> getAllAddonDetails() throws ClassNotFoundException, SQLException, IOException {
		
		return addonDao.getAllAddonDetails();
	}
	
	@Override
	public boolean ifAddonIdValid(int addonChoice) throws ClassNotFoundException, SQLException, IOException, IOException {
		
		return addonDao.ifAddonIdValid(addonChoice);
	}
	
	@Override
	public int getaddonPriceList(List<Integer> addonlist) throws ClassNotFoundException, SQLException, IOException, IOException {
		int totalAddonPrice=0;
		List<Integer> addonPriceList = new ArrayList<>();
		addonPriceList = addonDao.getaddonPriceList(addonlist);
		for(int p : addonPriceList) {
		totalAddonPrice += p;
		}
		
		return totalAddonPrice;
	}
	
	@Override
	public String getaddonNameList(List<Integer> addonlist) throws ClassNotFoundException, SQLException, IOException, IOException {
		String AllAddonName = null;
		List<String> addonNameList = new ArrayList<>();
		addonNameList = addonDao.getaddonNameList(addonlist);
		AllAddonName = String.join(",", addonNameList);
		return AllAddonName;
	}
	

}
