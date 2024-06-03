package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.User;
import util.stringUtils;

@WebServlet(asyncSupported = true, urlPatterns = {stringUtils.REGISTER_SERVLET})
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//creating the object of the database controller
	DatabaseController dbController = new DatabaseController();


	public registerServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter(stringUtils.USER_NAME);
		String firstName = request.getParameter(stringUtils.FIRST_NAME);
		String lastName = request.getParameter(stringUtils.LAST_NAME);
		String email = request.getParameter(stringUtils.EMAIL);
		String password = request.getParameter(stringUtils.PASSWORD);
		String retypePassword = request.getParameter(stringUtils.CONFIRM_PASSWORD);


		User userobj=new User(userName,firstName,lastName,password,email, false);
		
		int result = dbController.addProduct(userobj);
		
		if (password.equals(retypePassword)) {
			switch (result) {
				case 1 -> {
					request.setAttribute(stringUtils.SUCCESS_MESSAGE, stringUtils.SUCCESS_REGISTER_MESSAGE);
				    response.sendRedirect(request.getContextPath() + stringUtils.LOGIN_PAGE);
				}
				case 0 -> {
					request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.ERROR_REGISTER_MESSAGE);
				    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -1 -> {
					request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.SERVER_ERROR_MESSAGE);
				    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -2 -> {
					request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.USERNAME_ERROR_MESSAGE);
				    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -3 -> {
					request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.EMAIL_ERROR_MESSAGE);
				    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
				}
				case -4 -> {
					request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.PHONE_NUMBER_ERROR_MESSAGE);
				    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
				}
				default -> {
					request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.SERVER_ERROR_MESSAGE);
				    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
			}
			}
		}
		else {
			request.setAttribute(stringUtils.ERROR_MESSAGE, stringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
		    request.getRequestDispatcher(stringUtils.REGISTER_PAGE).forward(request, response);
		}
	}
}
;