package com.bean;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class Transaction {
	
	
	private int transaction_id;
	private String customer_name;
	private String orderId;
	private String orderDate;
	private String orderTime;
	private int totalPrice;
	private float discount;
	private float gst;
	private float serviceTax;
	private float totalBill;
	
	
}
