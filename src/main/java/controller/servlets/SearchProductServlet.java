package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.product;
import util.stringUtils;

/**
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController=new DatabaseController();

    public SearchProductServlet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        
        List<product> searchResults = dbController.getResultFromSearch(keyword);
        // Forward search results to the JSP
        request.setAttribute("searchResults", searchResults);
        System.out.print(searchResults);
        request.getRequestDispatcher(stringUtils.SEARCH_PAGE).forward(request, response);
    }
}