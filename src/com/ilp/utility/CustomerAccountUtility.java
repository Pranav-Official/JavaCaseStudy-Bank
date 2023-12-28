package com.ilp.utility;

import java.util.ArrayList;


import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.CustomerServices;
import com.ilp.service.ProductServices;

public class CustomerAccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int loopChoice = 1;
		Customer customer = null;
		
		ArrayList<Services> serviceList = new ArrayList<Services>();
		ArrayList<Product> productList = new ArrayList<Product>();
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("********welcome to Bank********");
			System.out.println("1.Create Service ");
			System.out.println("2.Create Product ");
			System.out.println("3.Create Customer ");
			System.out.println("4.Manage Accounts ");
			System.out.println("5.Display Customer ");
			System.out.println("6.Exit ");
			int mainMenuChoice = scanner.nextInt();
			
			switch (mainMenuChoice) {
			case 1:
				serviceList = ProductServices.createService(serviceList);
				break;
			case 2:
				productList = ProductServices.createProducts(productList,serviceList);
				break;
			case 3:
				customer = CustomerServices.createCostomer(productList);
				break;
			case 4:
				CustomerServices.manageCustomer(customer);
				break;
			case 5:
				CustomerServices.displayCustomer(customer);
				break;
			case 6:
				break;
			}
			System.out.println("Doyou want to return to main menu (yes=1,no = 0)");
			loopChoice = scanner.nextInt();

		} while (loopChoice == 1);
	}

}
