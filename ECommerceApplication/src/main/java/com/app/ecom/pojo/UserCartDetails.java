package com.app.ecom.pojo;

public class UserCartDetails {

	private int productId;
	private int userId;
	private String productName;
	private String description;
	private int price;
	private int quantity;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UserCartDetails(int productId, int userId, String productName, String description, int price, int quantity) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	// P.ID, C.USERID, P.NAME, P.DESCRIPTION, P.PRICE, C.QUANTITY
}
