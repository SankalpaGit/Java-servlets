package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.DatabaseController;
import model.product;
import util.stringUtils;


@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DatabaseController dbController = new DatabaseController();
 
    public ProductDetailServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the product ID from the request parameter
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        // method in DB controller to retrieve product details by ID
        product product = dbController.getProductById(productId);
        
        if (product != null) {
            // Set the product as an attribute in the request
            request.setAttribute("product", product);
            // Forward to the product detail JSP page
            request.getRequestDispatcher(stringUtils.PRODUCT_DETAIL_PAGE).forward(request, response);
        } 
}
}


