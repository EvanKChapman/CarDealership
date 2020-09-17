package com.carServlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class SellCarByVin
 */
@WebServlet("/SellCarByVin")
public class SellCarByVin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellCarByVin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// path - sales text 
		final String salePath = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/SaleData";
		final String saleFile = salePath+"/"+"sales.txt";
		// path - store updated inventory text 
		final String inventoryPath = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/InventoryData";
		final String inventoryFile = inventoryPath+"/"+"inventory.txt";
		// Path - store image file 
		final String imagePath = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/InventoryData/carPics";
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
		@SuppressWarnings("unchecked")
		ArrayList<SalesDescription> sales = (ArrayList<SalesDescription>) session.getAttribute("sales");
		InventoryLoader temp = new InventoryLoader();
		
		String vin = request.getParameter("vin");
		
		for (Car find : inventory) {
			if (find.getVin().equals(vin)) {
				// record sale
				
			// SalesDescription object - add to text to file (sales.txt)
				SalesDescription sold = new SalesDescription(request.getParameter("saleDate"),
						request.getParameter("buyerName"), request.getParameter("askingPrice"), find);
				
				// add new sale to txt file 
				sales.add(sold);
				sales.sort(temp.new saleDateSorter());
				session.setAttribute("sales", sales);
				
				try {
					FileWriter fileWriter = new FileWriter(saleFile);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					
					for (SalesDescription sale : sales) {
						printWriter.println(sale.stringToFile());
					}
					printWriter.close();
					request.setAttribute("message2", "Inventory Updated!");
				}
				catch(FileNotFoundException e) {
					request.setAttribute("message2", "Error: Inventory file not found!");
				} 
				catch (IOException e) {
					request.setAttribute("message2", "Error: Could not write to inventory file!");
				}
				// remove car from inventory 
				inventory.remove(find);
				File image = new File(imagePath + find.getImageName());
				image.delete();
				break;
			}
		}
		
		try {
			FileWriter fileWriter = new FileWriter(inventoryFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (Car car : inventory) {
				printWriter.println(car.stringToFile());
			}
			printWriter.close();
			request.setAttribute("message2", "Inventory updated!");
			request.setAttribute("message1","");
		}
		catch(FileNotFoundException e) {
			request.setAttribute("message2", "Error: Inventory File not found!");
		} 
		catch (IOException e) {
			request.setAttribute("message2", "Error: Could not write to inventory file!");
		}
		session.setAttribute("inventory", inventory);
		
		RequestDispatcher rs = request.getRequestDispatcher("results.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
