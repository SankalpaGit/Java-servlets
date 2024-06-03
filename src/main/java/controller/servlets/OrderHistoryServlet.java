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
import util.stringUtils;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DatabaseController dbController =new DatabaseController();
    
	
    public OrderHistoryServlet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("username");

        if (user != null) {
            String username = user.getUserName(); // Assuming getUsername() method returns the username
            int userId = dbController.getUserId(username);
            // Retrieve orders for the user from the database
            DatabaseController dbController = new DatabaseController();
            List<Orders> userOrders = dbController.getOrdersByUserId(userId);

            // Set the list of orders as a request attribute
            request.setAttribute("userOrders", userOrders);

            // Forward the request to the JSP page to display the orders
            request.getRequestDispatcher(stringUtils.PROFILE_PAGE).forward(request, response);
        } else {
            // User is not logged in, redirect to the login page
            response.sendRedirect(stringUtils.LOGIN_PAGE); // Assuming login.jsp is the login page
        }}

}
