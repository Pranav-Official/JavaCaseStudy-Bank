package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	
	private double chequeDeposit;

	public double getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}

	public LoanAccount(String productCode, String productName, ArrayList<Services> ServicesList, double chequeDeposit) {
		super(productCode, productName, ServicesList);
		this.chequeDeposit = chequeDeposit;
	}

	
	

}
