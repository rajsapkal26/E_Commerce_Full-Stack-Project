package com.org.request;

public class AddItemRequest {

	private Long priductId;
	private String size;
	private int quantity;
	private Integer price;
	
	
	public AddItemRequest() {
		// TODO Auto-generated constructor stub
	}


	public AddItemRequest(Long priductId, String size, int quantity, Integer price) {
		super();
		this.priductId = priductId;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
	}


	public Long getPriductId() {
		return priductId;
	}


	public void setPriductId(Long priductId) {
		this.priductId = priductId;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
	
	
}
