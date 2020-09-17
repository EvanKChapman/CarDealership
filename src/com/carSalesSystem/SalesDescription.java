package com.carSalesSystem;

public class SalesDescription {
	
	// Class properties 
	private String buyerName;
	private String saleDate;
	private String salePrice;
	public Car car = new Car();
	
	// Parameterized constructor 
	public SalesDescription(String saleDate, String buyerName, String salePrice, Car car) {
		super();
		this.saleDate = saleDate;
		this.buyerName = buyerName;
		this.salePrice = salePrice;
		this.car = car;
	}
	
	// Default constructor
	public SalesDescription() {
		
	}
	
	
	// Getters and Setters
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	
	public String getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	// toString method
	
	@Override
	public String toString() {
		return "Sales Transaction Description [Sale Date = " + saleDate + ", Buyer Name = " + buyerName + ", Sale Price = " + salePrice + ", Car = " + car;
	}
	
	// Print String to File method
	public String stringToFile() {
		return saleDate + "  ::  " + buyerName + "  ::  " + salePrice + "  ::  " + car.stringToFile();
	}
	

}
