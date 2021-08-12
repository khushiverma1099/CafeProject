package com.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.bean.Addon;
import com.bean.Coffee;
import com.bean.Customer;
import com.bean.OrderTable;
import com.bean.Transaction;
import com.service.AddonService;
import com.service.AddonServiceImpl;
import com.service.CoffeeService;
import com.service.CoffeeServiceImpl;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import com.service.OrderTableService;
import com.service.OrderTableServiceImpl;
import com.service.TransactionService;
import com.service.TransactionServiceImpl;
import com.service.VoucherService;
import com.service.VoucherServiceImpl;
import com.helper.DisplayOutput;
import com.helper.CustomerInputOutput;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Scanner;

public class CoffeePresentationImpl implements CoffeePresentation {

	
	int addonChoice, coffeeChoice,  orderCount=1, totalAmount=0;
	int ifVoucher = 0;
	private CustomerService customerService = new CustomerServiceImpl();
	private CoffeeService coffeeService = new CoffeeServiceImpl();
	private AddonService addonService = new AddonServiceImpl();
	private OrderTableService orderTableService = new OrderTableServiceImpl();
	private TransactionService transactionService = new TransactionServiceImpl();
	private VoucherService voucherService = new VoucherServiceImpl();
	private OrderTable orderTable = new OrderTable();
	private Transaction transaction = new Transaction();
	public CustomerInputOutput inputoutput = new CustomerInputOutput();
	
	
	@Override
	public void getDetail() {
		Scanner scanner=new Scanner(System.in);
		try {
			Customer customer = CustomerInputOutput.getCustomerData();
			if (customer.getCustomerName() != null)  {
			System.out.println("Hi!"+ customer.getCustomerName());
			transaction.setCustomer_name(customer.getCustomerName());
			System.out.println("---------------------------------");}
			else
				System.out.println("Customer Addition Failed!");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void showMenu() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("What would you like to have");
		Collection<Coffee> coffees = null;
		try {
				coffees = coffeeService.getAllCoffeeDetails();
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		for(Coffee cf: coffees) {
				DisplayOutput.displayCoffee(cf);
				System.out.println();
			}
		System.out.println("Enter your Choice");
		coffeeChoice = scanner.nextInt();
		
		
			try {
				if(coffeeService.ifCoffeeIdValid(coffeeChoice)== false) {
					do {
						System.out.println("Please Enter a Valid CoffeeId");
						coffeeChoice= scanner.nextInt();
						}
					while(coffeeService.ifCoffeeIdValid(coffeeChoice)== false);
				} 
			}catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
			
		
		try {
			orderTable.setPrice(coffeeService.getRecordById(coffeeChoice));
			orderTable.setCoffeeName(coffeeService.getCoffeeNameById(coffeeChoice));
			orderTable.setSize(coffeeService.getCoffeeSizeById(coffeeChoice));
		}
		catch (NullPointerException | ClassNotFoundException | SQLException | IOException e) {
			System.out.println("Please Enter valid_id");
			showMenu();
		}
		
		List<Integer> addonList = new ArrayList<>();
		do {
			Collection<Addon> addon = null;
			try {
				addon = addonService.getAllAddonDetails();
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
	
			for(Addon adon : addon) {
			DisplayOutput.displayAddon(adon);
			System.out.println();
			}
			System.out.println("Select Your Addon Choice");
			System.out.println("Press 10 for no add on");
			System.out.println("Press 0 to Go Back to Main Menu");
			addonChoice = scanner.nextInt();
			try {
				if(addonService.ifAddonIdValid(addonChoice)== false && addonChoice != 10 && addonChoice != 0) {
					do {
						System.out.println("Please Enter a Valid AddonId");
						addonChoice = scanner.nextInt();
						}
					while(addonService.ifAddonIdValid(addonChoice)== false && addonChoice != 10 && addonChoice != 0);
				} 
			}catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
			addonList.add(addonChoice);
		}
		while(addonChoice != 10 && addonChoice != 0);
		if(addonChoice == 0)
			showMenu();
		int  totalBill=0;
		try {
			orderTable.setAddonPrice(addonService.getaddonPriceList(addonList));
			orderTable.setAddonName(addonService.getaddonNameList(addonList));
			totalBill = orderTable.getPrice()+orderTable.getAddonPrice();
			orderTable.setTotalPrice(totalBill);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			orderTableService.insertOrderRecord(orderTable);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} 
			
		totalAmount += totalBill;
		System.out.println("Do you want to order more : ");
		System.out.println("Yes/No");
		scanner.nextLine();
		String moreChoice = scanner.nextLine();
		
		if(moreChoice.equalsIgnoreCase("Yes"))
		{
			orderCount++;
			showMenu();
		}
			
			System.out.println("If you have voucher id, Please enter it");
			System.out.println("If not press 0");
			ifVoucher = scanner.nextInt();
			try {
				if(voucherService.ifVoucherIdValid(ifVoucher)== false && ifVoucher != 0)  {
					do {
						System.out.println("Your Voucher is invalid");
						System.out.println("Please Enter a valid voucher");
						System.out.println("If do not have press 0");
						ifVoucher = scanner.nextInt();
						}
					while(voucherService.ifVoucherIdValid(ifVoucher)== false && ifVoucher != 0);
				} 
			}catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
			float discount = 0;
			if(ifVoucher != 0) {
				try {
					discount = voucherService.getVoucherById(ifVoucher);
					if(discount == 0)
						System.out.println("Your Voucher has expired");
					else
						System.out.println("You got a discount of " + discount + "%" );
				} catch (ClassNotFoundException | SQLException | IOException e) {
					e.printStackTrace();
				} 
			}	
			
			try {
				float billAmount[] = transactionService.calculateBill(totalAmount, discount);
				transaction.setTotalPrice(totalAmount);
				transaction.setOrderId(orderTableService.getOrderIdList(orderCount));
				transaction.setGst(billAmount[0]);
				transaction.setServiceTax(billAmount[1]);
				transaction.setTotalBill(billAmount[2]);
				transaction.setDiscount(billAmount[3]);
				transaction.setOrderTime((LocalTime.now()).toString());
				transaction.setOrderDate((LocalDate.now()).toString());
				
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			} 
			
			try {
				transactionService.insertTransactionRecord(transaction);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			} 
			
				Collection<Transaction> transaction = null;
				Collection<OrderTable> orderTable = null;
				try {
					transaction =  transactionService.getTransactionDetails();
					orderTable = orderTableService.getAllOrderDetails(orderCount);
					System.out.println("Order Id \t\tCoffee Name\t\tSize\t\tPrice\t\tAddon Name\t\tAddon Price\t\tTotal Price");
					for(OrderTable ordertable : orderTable) {
						DisplayOutput.displayOrder(ordertable);
						System.out.println();
						}
						for(Transaction transactions : transaction) {
							DisplayOutput.displayTransaction(transactions);
							System.out.println();
						}
						System.out.println("---------------------Thanks For Buying----------------------");
						System.out.println("\n\n********************************************************************************************************************\n\n");
				} catch (NullPointerException | ClassNotFoundException | SQLException | IOException e) {
					e.printStackTrace();
				}
				
			}
	
		}
	
