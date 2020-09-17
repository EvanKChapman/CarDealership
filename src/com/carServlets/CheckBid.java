package com.carServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBid
 */
@WebServlet("/CheckBid")
public class CheckBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double bidAmount = Double.parseDouble(request.getParameter("bidAmount"));
		double price = Double.parseDouble(request.getParameter("askingPrice"));
		
		if (bidAmount >= (price *.9)) {
			request.setAttribute("price", bidAmount);
			request.setAttribute("message3", "Bid Accepted, continue!");
		} else {
				request.setAttribute("price", price);
				request.setAttribute("message3", "Bid not accepted! Enter a higher bid!");
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("placeBid.jsp");
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
