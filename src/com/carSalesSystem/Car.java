package com.carSalesSystem;

public class Car {
	// Class properties
	
	private String purchaseDate;
	private String imageName;
	private String make;
	private String model;
	private String year;
	private String vin;
	private String mileage; 
	private String description;
	private String askingPrice;
	
	// Parameterized Constructor 
	public Car(String purchaseDate, String imageName, String year, String make, String model, String vin, String mileage, String askingPrice, String description) {
		this.purchaseDate = purchaseDate;
		this.imageName = imageName;
		this.year = year;
		this.make = make;
		this.model = model;
		this.vin = vin;
		this.mileage = mileage;
		this.askingPrice = askingPrice;
		this.description = description;
	}
	
	// Default Constructor 
	public Car() {
		
	}
	
	
	// Getters and Setters
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getImageName() {
		return imageName;
	}
	public void setimagename(String imageName) {
		this.imageName = imageName;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAskingPrice() {
		return askingPrice;
	}
	public void setAskingPrice(String askingPrice) {
		this.askingPrice = askingPrice;
	}
	
	
	// Print String to File method
	public String stringToFile() {
		return purchaseDate + "  ::  " + imageName + "  ::  " + year + "  ::  " + make + "  ::  " + model + "  ::  " + vin + "  ::  " + mileage + "  ::  " + askingPrice + "  ::  " + description;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Purchase Date = " + purchaseDate + ", Year = " + year + ", Make = " + make + ", Model = " + model + ", VIN = " + vin + ", Mileage = " + mileage + ", Asking Price = " + askingPrice;
	}
	

}
