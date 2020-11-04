package com.app.ecom.pojo;

public class Categories {

	private int id;
	private String name;
	private int sellerId;

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

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Categories(int id, String name, int sellerId) {
		super();
		this.id = id;
		this.name = name;
		this.sellerId = sellerId;
	}

	public Categories() {
		super();
	}

}
