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
import model.cart;
import util.stringUtils;


/**
 * Servlet implementation class OrderInsertServlet
 */
@WebServlet("/OrderInsertServlet")
public class OrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController= new DatabaseController();

    public OrderInsertServlet() {
        super();
      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("username");
        
        if (user != null) {
            System.out.println("This is the servlet called from the order button ============");

            // Retrieve user ID using the username
            String username = user.getUserName(); // Assuming getUsername() method returns the username
            int userId = dbController.getUserId(username);

            // Retrieve cart items for the current user
            List<cart> cartItems = dbController.getCartItemsForUser(userId);

            // Print the size of cartItems for debugging
            System.out.println("Number of cart items: " + cartItems.size());

            // Print each cart item for debugging
            for (cart item : cartItems) {
                System.out.println("Product Name: " + item.getProductName());
                System.out.println("Quantity: " + item.getQuantity());
                System.out.println("Price: " + item.getPice());
            }

            // Insert cart items into the order table
            int rowsAffected = dbController.insertOrders(cartItems);
            if (rowsAffected > 0) {
            	request.setAttribute("successMessage", "Thank you for purchasing from Sell Phone.");
            } else {
                // Failed to insert orders, redirect to error page
                response.sendRedirect("error.jsp");
            }
        } else {
            // User not logged in, redirect to login page
            response.sendRedirect(stringUtils.LOGIN_PAGE);
        }
    }

}
