package com.bean;

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

public class OrderTable {

	private int orderId;
	private String coffeeName;
	private String size;
	private int price;
	private String addonName;
	private int addonPrice;
	private int totalPrice;
}
