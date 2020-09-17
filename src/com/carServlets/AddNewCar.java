package com.carServlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.carSalesSystem.Car;

/**
 * Servlet implementation class AddNewCar
 */
@WebServlet("/AddNewCar")

// to upload files via servlet
@MultipartConfig
public class AddNewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Where we will store car pictures
		final String imagePath = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/InventoryData/carPics/";
		
		
		// Where we want to store new text 
		final String inventoryPath = "/Users/evanchapman/eclipse-workspace/CarDealership/WebContent/InventoryData";
		final String inventoryFile = inventoryPath+"/"+"inventory.txt";
		
		// Image filename and combine with path 
		Part filePart = request.getPart("file"); // I think that has to be inventoryFile - but I'm not sure
		String imageName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		final String imageFile = imagePath + imageName;
		
		// Create car object - add to text file (inventory) 
		Car add = new Car(
				request.getParameter("purchaseDate"),
				imageName,
				request.getParameter("year"),
				request.getParameter("make"),
				request.getParameter("model"),
				request.getParameter("vin"),
				request.getParameter("mileage"),
				request.getParameter("askingPrice"),
				request.getParameter("description"));
		
		// Save image file to carPics folder
		OutputStream out = null;
		InputStream fileContent = null;
		final PrintWriter writer = new PrintWriter(new File(imageFile));
		
		
		try {
			
		
		out = new FileOutputStream(new File(imageFile));
		fileContent = filePart.getInputStream();
		
		int read = 0;
		final byte[] bytes = new byte[1024];
		
		while ((read = fileContent.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		request.setAttribute("message1", "Image Uploaded");
		
		} 
		catch (FileNotFoundException fnf) {
			request.setAttribute("message1", "file not found");
		}
		
		
		// Add new car to text file 
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		ArrayList<Car> inventory = (ArrayList<Car>)session.getAttribute("inventory");
		InventoryLoader temp = new InventoryLoader();
		
		inventory.add(add);
		inventory.sort(temp.new purchaseDateSorter());
		session.setAttribute("inventory", inventory);
		
		try {
			FileWriter fileWriter = new FileWriter(inventoryFile);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for (Car car : inventory) {
				printWriter.println(car.stringToFile());
			}
			printWriter.close();
			request.setAttribute("message2", "Inventory Updated");
		}
		catch (FileNotFoundException e) {
			request.setAttribute("message2", "ERROR: Inventory file not found!");
		} catch (IOException e) {
			request.setAttribute("message2", "ERROR: Could not write to inventory file!");
		}
		
		if (out != null) {
			out.close();
		}
		if (fileContent != null) {
			fileContent.close();
		}
		
		if (writer != null) {
			writer.close();
		}
		
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
