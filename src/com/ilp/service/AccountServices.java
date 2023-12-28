package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingMaxAccount;
import com.ilp.entity.Services;

public class AccountServices {

	public static ArrayList<Account> createAccount(ArrayList<Account> accountList, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int accountChoice = 0;
		do {
			scanner.nextLine();
			System.out.println("Enter Account Number");
			String accountNumber = scanner.nextLine();
			System.out.println("Enter Account Type");
			String accountType = scanner.nextLine();

			System.out.println("Enter which product account");
			int i = 1;
			for (Product product : productList) {

				System.out.println(i++ + ". " + product.getProductName());

			}
			int accountIndex = scanner.nextInt();
			Product product = productList.get(accountIndex - 1);
			Double balance = 0.0;

			scanner.nextLine();

			int flag = 1;
			do {
				System.out.println("Enter Balance:");
				balance = scanner.nextDouble();

				if (product instanceof SavingMaxAccount) {
					SavingMaxAccount savingsMaxAccount = (SavingMaxAccount) product;
					Double minbalance = savingsMaxAccount.getMinimumBalance();
					if (balance < minbalance) {
						System.out.println("Insufficient Balance");
						flag = 0;
					} else {
						flag = 1;
					}

				}
			} while (flag == 0);

			Account account = new Account(accountNumber, accountType, balance, product);
			accountList.addLast(account);
			scanner.nextLine();
			System.out.println("Do you want to add more accounts? yes=1/no=0");
			accountChoice = scanner.nextInt();
		} while (accountChoice == 1);
		return accountList;
	}

	public static void manageAccount(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int serviceChoice = 0;
		do {
		System.out.println("Choose option\t 1. Deposit \t 2. Withdraw \t 3. Display Balance");
		
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
			depositMoney(selectedAccount);
			break;
		case 2:
			withdrawMoney(selectedAccount);
			break;
		case 3:
			displayBalance(selectedAccount);
			break;
		}
		System.out.println("Do you want to do more actins with accounts? yes=1/no=0");
		serviceChoice = scanner.nextInt();
		}while(serviceChoice==1);
	
	
	}


	

	private static void depositMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Product product = selectedAccount.getProduct();
		double ammoutDeposited;
		if(product instanceof LoanAccount) {
			LoanAccount product1 = (LoanAccount) product;
			System.out.println("Do you want 1.Cash Deposit or 2.Cheque Deposite?");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if(choice == 2) {
				System.out.println("Enter Amount to be deposited");
				ammoutDeposited = scanner.nextDouble();
				selectedAccount.setAccountBal(ammoutDeposited+(selectedAccount.getAccountBal()*product1.getChequeDeposit()));
				System.out.println("new Balance: " +selectedAccount.getAccountBal());
				scanner.nextLine();
				return;
				
			}
		}
		System.out.println("Enter Amount to be deposited");
		ammoutDeposited = scanner.nextDouble();
		selectedAccount.setAccountBal(ammoutDeposited+(selectedAccount.getAccountBal()));
		System.out.println("new Balance: " +selectedAccount.getAccountBal());
		scanner.nextLine();
		return;
		

	}
	
	private static void withdrawMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Product product = selectedAccount.getProduct();
		double amountWithdrawn;
		if(product instanceof SavingMaxAccount) {
			SavingMaxAccount account = (SavingMaxAccount) product;
			System.out.println("Enter Amount to be Withdrawn");
			amountWithdrawn = scanner.nextDouble();
			if(selectedAccount.getAccountBal()-amountWithdrawn<account.getMinimumBalance()) {
				System.out.println("Insufficient Balance");
				return;
			}
		}
		System.out.println("Enter Amount to be Withdrawn");
		amountWithdrawn = scanner.nextDouble();
		selectedAccount.setAccountBal(selectedAccount.getAccountBal()-amountWithdrawn);
		System.out.println("Withdrawal Success!");
		System.out.println("New Balnce = " + selectedAccount.getAccountBal());
	}
	
	private static void displayBalance(Account selectedAccount) {
		// TODO Auto-generated method stub
		System.out.println("Balance in the account = " + selectedAccount.getAccountBal());
	}

}
