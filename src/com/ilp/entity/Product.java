package com.ilp.entity;

import java.util.ArrayList;

public class Product {
	private String productCode;
	private String productName;
	ArrayList<Services> ServicesList = new ArrayList<Services>();
	public Product(String productCode, String productName, ArrayList<Services> ServicesList) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.ServicesList = ServicesList;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Services> getServicesList() {
		return ServicesList;
	}
	public void setServicesList( ArrayList<Services> ServicesList) {
		this.ServicesList = ServicesList;
	}
	


}
