package com.carServlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carSalesSystem.Car;
import com.carSalesSystem.SalesDescription;

/**
 * Servlet implementation class InventoryLoader
 */
@WebServlet("/InventoryLoader")
public class InventoryLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// create variables 
		ArrayList<Car> inventory = new ArrayList<>();
		ArrayList<SalesDescription> sales = new ArrayList<>();
		
		// Path to inventory file 
		final String path = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/InventoryData";
		String fileName = path+"/"+"inventory.txt";
		// 
		
		// path to sale data file 
		final String salePath = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/SaleData";
		 final String saleFile = salePath+"sales.txt"; // maybe - we may take "/" away
		// above was a final string - that may be why it didn't load
		
		// try/catch with inventory load 
		try {
			
			// read from file 
			//File file = new File("/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/InventoryData");
			Scanner inputEntry = new Scanner(new File(fileName));
				while (inputEntry.hasNextLine()) 
				{
					String info = inputEntry.nextLine();
					
					// Create a string array by separating string by pattern ::
					String[] data = info.split("  ::  ");  // maybe come back to this - if spacing isn't enough
					
					
					// Each element will be assigned to the properties from our Car class
					
					String purchaseDate = data[0];
					String imageName = data[1];
					String year = data[2];
					String make = data[3];
					String model = data[4];
					String vin = data[5];
					String mileage = data[6];
					String askingPrice = data[7];
					String description = data[8];
					
					Car add = new Car(purchaseDate, imageName, year, make, model, vin, mileage, askingPrice, description);
					inventory.add(add);	
				}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error reading from file!");
			e.printStackTrace();
			
		}
		inventory.sort(new purchaseDateSorter());
		
		// try/catch & load sales up 
		try {
			
			// read from file 
			Scanner inputEntry = new Scanner(new File(saleFile));
				while (inputEntry.hasNextLine()) {
					String info = inputEntry.nextLine();
					
					// Create a string array by separating string by pattern ::
					String[] data = info.split("  ::  "); // may have to space :: more.... 
					
					// Each element will be assigned to the properties from our Car class for entry
					String saleDate = data[0];
					String buyerName = data[1];
					String salePrice = data[2];
					String purchaseDate = data[3];
					String imageName = data[4];
					String year = data[5];
					String make = data[6];
					String model = data[7];
					String vin = data[8];
					String mileage = data[9];
					String askingPrice = data[10];
					String description = data[11];
					
					Car temp = new Car(purchaseDate, imageName, year, make, model, vin, mileage, askingPrice, description);
					SalesDescription addSale = new SalesDescription(saleDate, buyerName, salePrice, temp);
					sales.add(addSale);	
				}	
		}
		catch(FileNotFoundException e) {
			System.out.println("Error reading from file! Sale File not loading correctly!");
			// figure out what error is going on 
			//e.printStackTrace();
		}
		
		sales.sort(new saleDateSorter());
		
		// Get session and return updated data to inventory.jsp
		HttpSession session = request.getSession(true);
		session.setAttribute("inventory", inventory);
		session.setAttribute("sales", sales);
		RequestDispatcher rs = request.getRequestDispatcher("inventory.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public class purchaseDateSorter implements Comparator<Car> {
		@Override
		public int compare(Car o2, Car o1) {
			return o2.getPurchaseDate().compareTo(o1.getPurchaseDate());
		}
	}
	
	public class saleDateSorter implements Comparator<SalesDescription> {
		@Override
		public int compare(SalesDescription o1, SalesDescription o2) {
			return o2.getSaleDate().compareTo(o1.getSaleDate());
		}
	}

}
