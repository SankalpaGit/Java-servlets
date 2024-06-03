package model;
import java.io.File;


import javax.servlet.http.Part;

public class product  {
	private int id;
    private String name;
    private String brand;
    private int price;
    private String description;
    private int stock;
    private String productImageUrl;
    private String RAM;
    private String ROM;
    private String processor;
	public product(String name, String brand, int price, String description, int stock, Part productImage,
			String RAM, String ROM, String processor) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.productImageUrl = getImageUrl(productImage);
		this.RAM = RAM;
		this.ROM = ROM;
		this.processor = processor;
	}

	public product(int id,String name, String brand, int price, String description, int stock, Part productImage,
			String RAM, String ROM, String processor) {}
	


	public product() {
		// TODO Auto-generated constructor stub
	}

	
	///this was the constructor made fo the ggeting the details
	//used for displaying product servelet
	public product(int product_id, String name2, String brand2, int price2, String description2, int stock2,
			String productImage, String rAM2, String rOM2, String processor2) {
		// TODO Auto-generated constructor stub
		super();
		this.id=product_id;
		this.name=name2;
		this.brand=brand2;
		this.price=price2;
		this.description=description2;
		this.stock=stock2;
		this.productImageUrl=productImage;
		this.RAM=rAM2;
		this.ROM=rOM2;
		this.processor=processor2;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getROM() {
		return ROM;
	}
	public void setROM(String rOM) {
		ROM = rOM;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
    
	public String getImageUrl(Part imagePart) {
		String savePath = "/SellPhone/src/main/webapp/views/images/productImage";
		File fileSaveDir = new File(savePath);
		String imageUrlFromPart = null;
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String contentDisp = imagePart.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
			imageUrlFromPart = "default.jpg";
		}
		return imageUrlFromPart;
	}

	public String getImageUrlFromPart() {
		return productImageUrl;
	}

	public void setImageUrlFromPart(Part part) {
		this.productImageUrl = getImageUrl(part);
	}
	
}
