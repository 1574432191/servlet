package com.gjq.pojo;

public class Goods {
	private int id;
	private String name;
	private double price;
	private int number;
	private int status;
	
	public Goods() {
		super();
	}
	
	public Goods(int id, String name, double price, int number, int status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.status = status;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + ", status=" + status
				+ "]";
	}
	

}
