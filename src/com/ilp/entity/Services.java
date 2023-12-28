package com.ilp.entity;

public class Services {
	private String serviceName;
	private String serviceCode;
	private double rate;
	
	
	public Services(String serviceName, String serviceCode, double rate) {
		super();
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.rate = rate;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
