package com.myretail.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProductInformationResponseTest {
	
	private ProductInformationResponse productInformationResponse;
	private Long id = 10l;
	private String name = "name";
	private Price price;
	private BigDecimal value;

	@Before
	public void setUp() throws Exception {
		productInformationResponse = new ProductInformationResponse();
		productInformationResponse.setId(id);
		productInformationResponse.setName(name);
		price = new Price();
		price.setCurrencyCode("USD");
		value = new BigDecimal(10.00);
		price.setValue(value);
		productInformationResponse.setCurrent_Price(price);
	}

	@Test
	public void testGetId() {
		assertEquals(id, productInformationResponse.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("name", productInformationResponse.getName());
	}

	@Test
	public void testGetCurrent_Price() {
		assertEquals(price, productInformationResponse.getCurrent_Price());
	}

}
