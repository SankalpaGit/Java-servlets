package controller.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.DatabaseController;
import model.User;
import util.stringUtils;

@WebServlet(asyncSupported = true, urlPatterns = stringUtils.LOGIN_SERVLET)
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();

    public loginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String userName = request.getParameter("username");
    String password = request.getParameter("password");

    // Check login credentials
    User user = dbController.getLoginUserInfo(userName, password);

    if (user != null) {
        HttpSession userSession = request.getSession();
        userSession.setMaxInactiveInterval(30*60);
        userSession.setAttribute("username", user);
		int user_id = dbController.getUserId(userName);
        userSession.setAttribute("user_id", user_id);
        // Set session timeout to 30 minutes (in seconds)
        userSession.setMaxInactiveInterval(30 * 60);

        Cookie userCookie = new Cookie("user", userName);
        userCookie.setMaxAge(30 * 60);
        response.addCookie(userCookie);

        // Redirect based on user role
        if (user.isAdmin()) {
            // Redirect admin to admin home page
        	userSession.setAttribute("isAdmin", true);
        	
            response.sendRedirect(request.getContextPath() + stringUtils.DISPLAY_PRODUCT_SERVLET);
            System.out.print("Admin login garyo ambooo==========");
            
        } else {
            // Redirect normal user to normal user home page
        	userSession.setAttribute("isAdmin", false);
            response.sendRedirect(request.getContextPath() + stringUtils.DISPLAY_PRODUCT_SERVLET);
            System.out.println("User Login Sucessfully");
            
        }
    } else {
        // Set error message for invalid credentials and forward to login page
        request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.ERROR_LOGIN_MESSAGE);
        request.getRequestDispatcher(stringUtils.LOGIN_PAGE).forward(request, response);
    }
}

}
