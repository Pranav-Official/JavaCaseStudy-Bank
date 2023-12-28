package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;

public class CustomerServices {

	public static Customer createCostomer(ArrayList<Product> productList) {
		if(productList.size()<1) {
			System.out.println(" Create products to create customer and accounts");
			return null;

		}

		ArrayList<Account> accountList = new ArrayList<Account>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Customer code");
		String customerCode = scanner.nextLine();
		System.out.println("Enter Customer Name");
		String customerName = scanner.nextLine();

		accountList = AccountServices.createAccount(accountList, productList);

		Customer customer = new Customer(customerCode, customerName, accountList);

		System.out.println(" Your Accounts is active!");
		System.out.println(" Your Accounts are");
		for (Account account : accountList) {
			System.out.println(account.getAccountNo()+"\t"+account.getAccountType());
			System.out.println(" Your available services are :-");
			Product product = account.getProduct();
			ArrayList<Services> services = product.getServicesList();

			for (Services service : services) {
				System.out.println(service.getServiceName());
			}
		}

		return customer;
	}

	public static void manageCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if(customer==null) {
			System.out.println("Create Customer first");
			return;
		}
		System.out.println("Hi " + customer.getCustomerName());
		System.out.println(" accounts available for you are:-");
		System.out.println("No\t AccountNo\t AccountType");
		ArrayList<Account> accountList = customer.getAccountList();
		int choice = 0;
		do {

			int i = 1;
			for (Account account : accountList) {
				System.out.println(i++ + "\t" + account.getAccountNo() + "\t" + account.getAccountType());
			}
			System.out.println("Choose Any Account to perform transaction");
			Scanner scanner = new Scanner(System.in);
			int accountChoice = scanner.nextInt();

			Account selectedAccount = accountList.get(accountChoice - 1);
			AccountServices.manageAccount(selectedAccount);
			System.out.println("Do you want to choose more accounts?(1=yes/0=no)");
			choice = scanner.nextInt();
		} while (choice == 1);
	}

	public static void displayCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if(customer==null) {
			System.out.println("Create Customer first");
			return;
		}
		System.out.println("*****************CUSTOMER DETAILS******************");
		System.out.println("CustomerID\t\t CustomerName\t\t AccountType\t\t Balance");
		System.out.println("****************************************************");
		ArrayList<Account> accountList = customer.getAccountList();
		ArrayList<Services> serviceList;
		for (Account account : accountList) {
			System.out.println(customer.getCustomerCode() + "\t\t" + customer.getCustomerName() + "\t\t"
					+ account.getAccountType() + "\t\t" + account.getAccountBal());
			System.out.println("");
			serviceList = account.getProduct().getServicesList();
			System.out.println("Services Available");
			for (Services service : serviceList) {
				System.out.print(service.getServiceName() + ",");
			}

		}
	}
}
