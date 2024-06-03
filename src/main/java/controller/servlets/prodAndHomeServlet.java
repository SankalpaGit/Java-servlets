package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.DatabaseController;
import util.stringUtils;
import model.product;


@WebServlet(asyncSupported = true, urlPatterns = {stringUtils.HOME_SERVLET})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB)

public class prodAndHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//creating the object of the database controller
	DatabaseController dbController = new DatabaseController();


	public prodAndHomeServlet() {
		super();
	}
	
    //this is the methods
	/* used to send the data of the form used in the admin page to the database*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form form input field
        String name = request.getParameter("productName");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Part imagePart = request.getPart(stringUtils.PRODUCT_IMAGE);
        
        String RAM = request.getParameter("ram");
        String ROM = request.getParameter("rom");
        String processor = request.getParameter("processor");

        // Create product object
        product prod = new product(name, brand, price, description, stock, imagePart, RAM, ROM, processor);
        
        String savePath = stringUtils.IMAGE_DIR_PATH;
		String fileName = prod.getImageUrlFromPart();
		System.out.println("hujuj" + fileName);
		
		
		if (!fileName.isEmpty() && fileName != null) {
			imagePart.write(savePath + fileName);
		}
        // Insert product into database
        int result = dbController.insertProduct(prod);

        if (result != -1) {
            // Product insertion successful, redirect to success page
        	request.setAttribute(stringUtils.SUCCESS_MESSAGE, stringUtils.SUCCESS_PRODUCTADD_MESSAGE);
//        	response.sendRedirect(request.getContextPath() + stringUtils.ADMIN_PAGE);
        } 
        else if(result ==3){
        	request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.EXTRA_MESSAGE);
        }
        else {
            // Product insertion failed, redirect to error page
            response.sendRedirect("error.jsp");
        }
    }
	

}
