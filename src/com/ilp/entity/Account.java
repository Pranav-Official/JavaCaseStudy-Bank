package com.ilp.entity;

public class Account {

	private String accountNo;
	private String accountType;
	private double accountBal;
	private Product product;

	

	public Account(String accountNo, String accountType, double accountBal, Product product) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBal = accountBal;
		this.product = product;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}

}
