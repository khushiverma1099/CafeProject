package com.helper;

import com.bean.Addon;
import com.bean.Coffee;
import com.bean.OrderTable;
import com.bean.Transaction;

public class DisplayOutput {
	
	public static void displayCoffee(Coffee coffee) {
		System.out.print(coffee.getCoffeeId()+"\t\t"+coffee.getCoffeeName()+"\t\t"+coffee.getPrice()+"\t\t"+coffee.getSize());
	}

	
	public static void displayAddon(Addon coffee) {
		System.out.print(coffee.getAddonId()+"\t\t"+coffee.getAddonName()+"\t\t"+coffee.getPrice());
	}

	
	public static void displayTransaction(Transaction transaction) {
		System.out.println("Customer Name : " + transaction.getCustomer_name());
		System.out.println("Total Price : " + transaction.getTotalPrice());
		System.out.println("Discount : " + transaction.getDiscount());
		System.out.println("GST(18%) : "+ transaction.getGst());
		System.out.println("Service Tax(8%) : " + transaction.getServiceTax());
		System.out.println("Total Bill : " + transaction.getTotalBill());
		System.out.println("Transaction Id : " + transaction.getTransaction_id()+"\t"+"Date : " + transaction.getOrderDate()+"\t"+"Time : " + transaction.getOrderTime());

	}
	
	public static void displayOrder(OrderTable orderTable) {
		if(orderTable.getAddonPrice()==0) {
			System.out.println("\t"+orderTable.getOrderId()+"\t\t"+orderTable.getCoffeeName()+"\t\t"+orderTable.getSize()+"\t\t"+orderTable.getPrice()+"\t\t"+"none"+"\t\t\t"+orderTable.getAddonPrice()+"\t\t\t"+orderTable.getTotalPrice());
			}
		else
			System.out.println("\t"+orderTable.getOrderId()+"\t\t"+orderTable.getCoffeeName()+"\t\t"+orderTable.getSize()+"\t\t"+orderTable.getPrice()+"\t\t"+orderTable.getAddonName()+"\t\t\t"+orderTable.getAddonPrice()+"\t\t\t"+orderTable.getTotalPrice());

	}
}
