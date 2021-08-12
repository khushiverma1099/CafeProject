package com.helper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.bean.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;

public class CustomerInputOutput {
	
		private static CustomerService customerService = new CustomerServiceImpl();
		
		public static Customer getCustomerData() throws ClassNotFoundException, SQLException, IOException {
			Scanner scanner = new Scanner(System.in);
			String phone;
			System.out.println("-----Welcome to Coffee Cafe-----");
			System.out.println("Please Enter Your Mobile Number:");
			phone = scanner.nextLine();
			if(customerService.ifPhoneValid(phone)== false) {
			do {
				System.out.println("Please Enter Valid Mobile Number:");
				phone = scanner.nextLine();
		    	}
		    while(customerService.ifPhoneValid(phone)== false);
			}
			if(customerService.ifPhoneExist(phone))
		    	{
		    		String name = customerService.getName(phone);
		    		Customer customer1 = new Customer(name,phone);
		    		return customer1;
		    	}
			
		    	else {
		    		System.out.println("Please Enter Your Name:");
		    		String name = scanner.nextLine();	
		    		if(customerService.ifNameValid(name)== true) {
		    			do {
		    				System.out.println("Sorry,Null Name is not allowed...You have to enter proper name");
		    				name = scanner.nextLine();
		    		    	}
		    		    while(customerService.ifNameValid(name)== true);
		    			}
		    		Customer customer = new Customer(name, phone);
		    		if(customerService.insertCustomer(customer))
		    			return customer;
		    		else
		    			return customer=null;
		    	}
		    }
		}


