package com.ilp.service;

import java.util.ArrayList;

import java.util.Scanner;

import com.ilp.entity.Product;
import com.ilp.entity.SavingMaxAccount;
import com.ilp.entity.Services;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;

public class ProductServices {
	
	public static ArrayList<Services> createService(ArrayList<Services> serviceList) {
		String serviceName;
		String serviceCode;
		double serviceRate;
		
		Scanner scanner = new Scanner(System.in);
		int loopchoice;
		do {
		Services service = null;
		System.out.println("Enter what kind of service \n 1.CashDeposit. \n 2. ATMWithdrawl. \n 3. OnlineBanking \n 4. MobileBanking \n 5. ChequeDeposit");
		int serviceChoice = scanner.nextInt();
		System.out.println("Enter Service code");
		serviceCode = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter Service Rate");
		serviceRate = scanner.nextDouble();
		switch (serviceChoice) {
		case 1:
			service = new Services("Cash Deposit",serviceCode, serviceRate);
			serviceList.addLast(service);
			break;
		case 2:
			service = new Services("ATMWithdrawl",serviceCode, serviceRate);
			serviceList.addLast(service);
			break;
		case 3:
			service = new Services("OnlineBanking",serviceCode, serviceRate);
			serviceList.addLast(service);
			break;
		case 4:
			service = new Services("MobileBanking",serviceCode, serviceRate);
			serviceList.addLast(service);
			break;
		case 5:
			service = new Services("Cheque Deposit",serviceCode, serviceRate);
			serviceList.addLast(service);
			break;
		}
		scanner.nextLine();
		System.out.println("Do yo want to enter more (yea=1,no=0)");
		loopchoice = scanner.nextInt();
		}while(loopchoice==1);
		return serviceList;
		
	}
	
	public static ArrayList<Product> createProducts(ArrayList<Product> productList, ArrayList<Services> serviceList) {
		if(serviceList.size()<1) {
			System.out.println("Create Services first create products");
			return productList;

		}
		String productCode;
		ArrayList<Services> serviceListToBeAdded = new ArrayList<Services>();
		
		Scanner scanner = new Scanner(System.in);
		int loopchoice;
		do {
		System.out.println("Enter what kind of Product \n 1. SavingsMaxAccount \n 2. CurrentAccount. \n 3. LoanAccount");
		int serviceChoice = scanner.nextInt();
		scanner.nextLine();
		switch (serviceChoice) {
		case 1:
			System.out.println("Enter Product code");
			productCode = scanner.nextLine();
			serviceListToBeAdded = addServices(serviceList);
			System.out.println("Enter Minimum Balance");
			double minimumBalance = scanner.nextDouble();
			SavingMaxAccount SavingsProduct = new SavingMaxAccount(productCode, "SavingsMaxAccount", serviceListToBeAdded, minimumBalance);
			productList.addLast(SavingsProduct);
			break;
		case 2:
			System.out.println("Enter Product code");
			productCode = scanner.nextLine();
			serviceListToBeAdded = addServices(serviceList);
			CurrentAccount currentAccountProduct = new CurrentAccount(productCode, "CurrentAccount", serviceListToBeAdded);
			productList.addLast(currentAccountProduct);
			break;
		case 3:
			System.out.println("Enter Product code");
			productCode = scanner.nextLine();
			serviceListToBeAdded = addServices(serviceList);
			double chequeDeposit = 0.003;
			LoanAccount LoanAccountProduct = new LoanAccount(productCode, "LoanAccount", serviceListToBeAdded,chequeDeposit);
			productList.addLast(LoanAccountProduct);
			break;

		}
		System.out.println("Do yo want to enter more (yea=1,no=0)");
		loopchoice = scanner.nextInt();
		}while(loopchoice==1);
		return productList;
		
	}

	private static ArrayList<Services> addServices(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		ArrayList<Services> serviceListToBeAdded = new ArrayList<Services>();
		System.out.println("Enter services to add eg(1,2,3)");
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		for(Services service:serviceList) {
			
			System.out.println(i++ + ". "+ service.getServiceName());
			
		}
		String options = scanner.nextLine();
		String[] optionsList = options.split(",");
		int j=-1;
		for(String option: optionsList) {
//			j = ;
			serviceListToBeAdded.addLast(serviceList.get(Integer.parseInt(option)-1));
		}
		
		return serviceListToBeAdded;
	}
	
	
}