package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.Orders;
import model.User;
import model.product;
import util.stringUtils;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet(asyncSupported = true, urlPatterns = stringUtils.DISPLAY_PRODUCT_SERVLET)
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseController dbController = new DatabaseController();
	
	public DisplayProductServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("username");

	    // Check if the user is logged in
	    if (user != null) {
	        System.out.println("User is logged in. Retrieving products.");

	        // Retrieve product data from the database
	        List<product> products = dbController.getAllProducts();

	        // Set the products as an attribute in the request
	        request.setAttribute("products", products);

	        // Check if the user is an admin
	        if (user.isAdmin()) {
	            // Retrieve all orders from the database
	            List<Orders> orders = dbController.getAllOrders();

	            // Log the orders for debugging
	            if (orders != null) {
	                System.out.println("Number of orders retrieved: " + orders.size());
	                for (Orders order : orders) {
	                    System.out.println("Order ID: " + order.getOrderId());
	                    System.out.println("Product ID: " + order.getProductId());
	                    System.out.println("User ID: " + order.getUserId());
	                    System.out.println("Product Name: " + order.getProductName());
	                    System.out.println("Order Status: " + order.getOrderStatus());
	                    System.out.println("Order Date: " + order.getOrderDate());
	                    System.out.println("Quantity: " + order.getQuantity());
	                }
	            } else {
	                System.out.println("No orders retrieved from the database.");
	            }

	            // Set the orders attribute
	            request.setAttribute("orders", orders);
	        }

	        // Forward the request to the appropriate page
	        if (user.isAdmin()) {
	            request.getRequestDispatcher(stringUtils.ADMIN_PAGE).forward(request, response);
	        } else {
	            request.getRequestDispatcher(stringUtils.HOME_PAGE_LOGIN).forward(request, response);
	        }
	    } else {
	        // If user is not logged in, redirect to login page
	        response.sendRedirect(stringUtils.LOGIN_PAGE);
	    }
	}

	

}
