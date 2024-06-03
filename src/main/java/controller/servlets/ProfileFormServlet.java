package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.User;

/**
 * Servlet implementation class ProfileFormServlet
 */
@WebServlet("/ProfileFormServlet")
public class ProfileFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user"); // Assuming the user object is stored in the session

        if (user != null) {
        	 String username = user.getUserName();
        	int userId = dbController.getUserId(username); // Assuming getUserId() returns the user's ID
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String description = request.getParameter("description");
            
           
            int result = dbController.insertProfileData(userId, firstName, lastName, email, phoneNumber, description);
            
            if (result > 0) {
                // Profile data inserted successfully
                response.sendRedirect("profile.jsp");
            } else {
                // Error occurred while inserting profile data
                response.sendRedirect("error.jsp");
            }
        } else {
            // User is not logged in, redirect to login page
            response.sendRedirect("login.jsp");
        }
    }


}
