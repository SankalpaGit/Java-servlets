package model;

import java.sql.Date;

public class Orders {
	
	private int orderId;
    private int productId;
    private int userId;
    private String productName;
    private String orderStatus;
    private Date orderDate;
    private int quantity;
    
	public Orders(int orderId, int productId, int userId, String productName, String orderStatus, Date orderDate,
			int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}

	

	public Orders(int orderId2, int productId2, int userId2, String productName2, String orderStatus2,
			java.util.Date orderDate2, int quantity2) {
		// TODO Auto-generated constructor stub
		super();
		this.orderId = orderId2;
		this.productId = productId2;
		this.userId = userId2;
		this.productName = productName2;
		this.orderStatus = orderStatus2;
		this.orderDate = (Date) orderDate2;
		this.quantity = quantity2;
	}



	public Orders() {
		// TODO Auto-generated constructor stub
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
	
}
