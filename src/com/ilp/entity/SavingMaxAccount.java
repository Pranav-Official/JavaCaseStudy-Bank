package com.ilp.entity;

import java.util.ArrayList;

public class SavingMaxAccount extends Product {
	private double minimumBalance;

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public SavingMaxAccount(String productCode, String productName, ArrayList<Services> ServicesList,
			double minimumBalance) {
		super(productCode, productName, ServicesList);
		this.minimumBalance = minimumBalance;
	}
	
	

}
