package util;

import java.io.File;

public class stringUtils {
	
	//SQL Query to insert the values in User tables
	// store the value to the User when user get registered
	public static final String INSERT_STUDENT = "INSERT INTO user "
			+ "(userName, firstName, lastName, password, email) " //User table's attibute name
			+ "VALUES (?, ?, ?, ?, ?)";
	
	//SQL query for getting the user name and password
	public static final String GET_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE userName = ? AND password = ?";
	
	//query for the searching the product
	//search the product by the names of product
	public static final String SEARCH_QUERRY= "SELECT * FROM product WHERE name LIKE '?'";
	public static final String ABOUT_FORM="ISERT INTO form"
	+ "(phoneNumber, email, message)"
	+ "VALUES (?, ?, ?)";
	//SQL Querry for the inserting the items in the cart
	public static final String ADD_TO_CART_QUERY= "INSERT INTO cart " 
	+ "(userId, productImage, productId, productName, quantity, price)"
	+ "VALUES (?, ?, ?, ?, ?, ?)";
	
	//SQL Query for inserting the value in the product table
	//Below is the name of attributr of the db product table column name
	 public static final String INSERT_PRODUCT = "INSERT INTO product "
	 + "(name, brand, price, description, stock, productImageUrl, RAM, ROM, processor)"+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 
	 public static final String INSERT_USER_PROF_DATA = "INSERT INTO user_profile "
	 + "(userId, firstName, lastName, email, phoneNumber, description)"+" VALUES (?, ?, ?, ?, ?, ?)";
	 
	 
	 //getting the details of the product database
	 //select all the column of the product table
	 public static final String GET_PRODUCT= "SELECT * FROM product ";
	 public static final String GET_ORDERS= "SELECT * FROM orders ";
	 public static final String SELECT_PROD_BY_ID= "SELECT * FROM product WHERE productId = ?";
	
	//this is the string Query for the getting the user inform
	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM user WHERE userName = ?";
	public static final String GET_USERNAME = "SELECT COUNT(*) FROM user WHERE userName = ?";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM user WHERE email = ?";
	public static final String GET_ALL_USER = "SELECT * FROM user";
	
	//Query for the getting the user id
	public static final String GET_USERID= "SELECT userId from user where userName = ?";
	
	//Join query 
	//Query that join the table
	//Used to show the cart item to be displayed.
	public static final String CART_INFORMATION="SELECT * FROM cart WHERE userId = ?";
	public static final String UPDATE_CART_QUANTITY_QUERY = "UPDATE cart SET quantity = ? WHERE productId = ?";
	public static final String INSERT_ORDERS_QUERY = "INSERT INTO orders (productId, userId, productName, orderStatus, orderDate, quantity) VALUES (?, ?, ?, ?, ?, ?)";

	//String of the messages to display
	//this is the message for the authentication part
	public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered!";
	public static final String ERROR_REGISTER_MESSAGE = "Please correct the form data.";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
	public static final String USERNAME_ERROR_MESSAGE = "Username is already registered.";
	public static final String EMAIL_ERROR_MESSAGE = "Email is already registered.";
	public static final String PHONE_NUMBER_ERROR_MESSAGE = "Phone Number is already registered.";
	public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password not matched.";
	
	//messages to display for the login
	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully LoggedIn!";
	public static final String ERROR_LOGIN_MESSAGE = "Either username or password is not correct!";
	
	
	//defining the two types of the messages
	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String SUCCESS_MESSAGE="successfull";
	
	//messages for the adding the product
	public static final String SUCCESS_PRODUCTADD_MESSAGE = "Successfully product is added!";
	public static final String EXTRA_MESSAGE = "there is a problem";
	// End string messages 
	
	
	// name of the input field from the front end pages 
	// this is then names from the register.jsp page 
	public static final String USER_NAME = "username";
	public static final String FIRST_NAME = "firstname";
	public static final String LAST_NAME = "lastname";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String CONFIRM_PASSWORD = "confirm-password";
	
	
	//name of the admin page add the product form
	//this is the admin page form name
	public static final String PRODUCT_NAME="productName";
	public static final String BRAND="brand";
	public static final String STOCK="stock";
	public static final String PRICE="price";
	public static final String DESCRIPTION="description";
	public static final String RAM="ram";
	public static final String ROM="rom";
	public static final String PROCESSOR="processor";
	public static final String PRODUCT_IMAGE="productImage";
	
	
	//directory for the adding the images 
	//when the data is added the images file save to this directory
	public static final String IMAGE_DIR = "\\Users\\DELL\\eclipse-workspace\\SellPhone\\src\\main\\webapp\\views\\images\\productImage\\";
	public static final String IMAGE_DIR_PATH = "C:" + File.separator + IMAGE_DIR;

	
	
	// Route of the JSP pages that is front end
	//setting up the route of the pages
	public static final String LOGIN_PAGE = "/SellPhone/views/pages/login.jsp";
	public static final String REGISTER_PAGE = "/views/pages/register.jsp";
	public static final String HOME_PAGE_LOGIN = "/views/pages/homeMain.jsp";
	public static final String ADMIN_PAGE= "/views/pages/Admin.jsp";
	public static final String CART_PAGE= "/views/pages/cart.jsp";
	public static final String PROFILE_PAGE= "/views/pages/profile.jsp";
	public static final String EDIT_PROFILE= "/SellPhone/views/pages/editProfile.jsp";
	public static final String ABOUT_PAGE= "/SellPhone/views/pages/about.jsp";
	public static final String PRODUCT_DETAIL_PAGE= "/views/pages/productOverview.jsp";
	public static final String SEARCH_PAGE="/views/pages/searchResult.jsp";

	// Route for the servlets files
	//route of the servelet files
	public static final String REGISTER_SERVLET = "/registerServlet";
	public static final String LOGIN_SERVLET = "/loginServlet";
	public static final String HOME_SERVLET= "/prodAndHomeServlet";
	public static final String DISPLAY_PRODUCT_SERVLET=	"/DisplayProductServlet";
	public static final String SEARCH_PRODUCT_SERVLET="/SearchProductServlet";
	public static final String PRODUCT_DETAIL_SERVLET= "/ProductDetailServlet";
	public static final String ADD_CART_SERVLET="/AddToCartServlet";
	public static final String DISPLAY_CART_SERVLET="/CartDisplayServlet";
	public static final String ORDER_LIST_SERVLET="/OrderListServlet";
}
