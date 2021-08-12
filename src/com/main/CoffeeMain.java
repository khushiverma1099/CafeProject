package com.main;

import java.util.Scanner;

import com.presentation.CoffeePresentation;
import com.presentation.CoffeePresentationImpl;


public class CoffeeMain {

	public static void main(String[] args) {
		
	CoffeePresentation coffeePresentation = new CoffeePresentationImpl();
	
	
	Scanner scanner=new Scanner(System.in);
	while(true) {
		coffeePresentation.getDetail();
		coffeePresentation.showMenu();
		

		
	}
	}
}
