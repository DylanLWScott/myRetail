package com.myretail.model;

public class ProductInformationResponse {
	
	private Long id;
	private String name;
	private Price current_Price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Price getCurrent_Price() {
		return current_Price;
	}
	public void setCurrent_Price(Price current_Price) {
		this.current_Price = current_Price;
	}
	
}
