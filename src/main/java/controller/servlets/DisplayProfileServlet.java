package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/DisplayProfileServlet")
public class DisplayProfileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user"); // Assuming the user object is stored in the session

        if (user != null) {
            // User is logged in, redirect to profile page
            response.sendRedirect("");
        } else {
            // User is not logged in, redirect to login page
            response.sendRedirect("login.jsp");
        }
    }
}
