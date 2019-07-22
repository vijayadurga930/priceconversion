package com.cg.beans;

public class Product {
	String productname;
    double price;
    int quantity;
	@Override
	public String toString() {
		return "Product [" + productname + ", " + price + ", " + quantity + "]";
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(String productname, double price, int quantity) {
		super();
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
