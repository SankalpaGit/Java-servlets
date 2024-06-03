package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import util.stringUtils;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/UpdateCartQuantityServlet")
public class UpdateCartQuantityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract productId from parameter name
        String productIdParam = request.getParameterNames().nextElement();
        int productId = Integer.parseInt(productIdParam.substring("quantity_".length()));

        // Retrieve the quantity from the request parameters
        int quantity = Integer.parseInt(request.getParameter(productIdParam));

        // Update the quantity in the cart table in the database
        DatabaseController dbController = new DatabaseController();
        int rowsAffected = dbController.updateCartQuantity(productId, quantity);

        if (rowsAffected > 0) {
            request.setAttribute("successMessage", "Quantity updated successfully.");
        } else {
            request.setAttribute("errorMessage", "Failed to update quantity.");
        }
        request.getRequestDispatcher(stringUtils.CART_PAGE).forward(request, response);
    }


    }

