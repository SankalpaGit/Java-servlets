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
import model.User;
import model.cart;
import util.stringUtils;


@WebServlet("/CartDisplayServlet")
public class CartDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
	
    public CartDisplayServlet() {
        super();

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("username");

        // Check if the user is logged in
        if (user != null) {
            System.out.println("User is logged in. Retrieving cart items.");

            // Retrieve user ID using the username
            String username = user.getUserName(); // Assuming getUsername() method returns the username
            int userId = dbController.getUserId(username);

            // Retrieve cart items for the current user
            List<cart> cartItems = dbController.getCartItemsForUser(userId);

            // Print the size of cartItems for debugging
            System.out.println("Number of cart items: " + cartItems.size());

            // Print each cart item for debugging
            for (cart item : cartItems) {
            	System.out.println("Product Name: " + item.getProductImage());
                System.out.println("Product Name: " + item.getProductName());
                System.out.println("Quantity: " + item.getQuantity());
                System.out.println("Price: " + item.getPice());
            }

            // Set the cart items as an attribute in the request
            request.setAttribute("cartItems", cartItems);

            // Forward the request to the cart page
            request.getRequestDispatcher(stringUtils.CART_PAGE).forward(request, response);
        } else {
            // If user is not logged in, redirect to login page
            response.sendRedirect(stringUtils.LOGIN_PAGE);
        }
    }





}
    
