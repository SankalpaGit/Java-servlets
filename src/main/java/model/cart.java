package model;

public class cart {
    private int userId;
    private String productImage;
    private int productId;
    private String productName;
    private int quantity;
    private int pice;
	public cart(int userId, String productImage, int productId, String productName, int quantity, int pice) {
		super();
		this.userId = userId;
		this.productImage = productImage;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.pice = pice;
	}
	public cart() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPice() {
		return pice;
	}
	public void setPice(int pice) {
		this.pice = pice;
	}
    
	
    
}
