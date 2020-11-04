package com.app.ecom.pojo;

import java.util.Date;

public class Orders {

	private int id;
	private int totalAmount;
	private int userId;
	private int productId;
	private Date orderDate;
	private int quantity;
	private String paymentInfo;
	private String orderStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Orders(int totalAmount, int userId, int productId, Date orderDate, int quantity, String paymentInfo,
			String orderStatus) {
		super();
		this.totalAmount = totalAmount;
		this.userId = userId;
		this.productId = productId;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.paymentInfo = paymentInfo;
		this.orderStatus = orderStatus;
	}

	public Orders() {
		super();
	}

}
