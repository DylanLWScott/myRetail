package com.myretail.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ProductPriceTest {
	
	private ProductPrice productPrice;
	private BigDecimal value;
	private Long productId = 12l;
	private static final String USD = "USD";

	@Before
	public void setUp() throws Exception {
		productPrice = new ProductPrice();
		value = new BigDecimal(10.00);
		productPrice.setPrice(value);
		productPrice.setCurrencyCode(USD);
		productPrice.setProductId(productId );
	}

	@Test
	public void testGetProductId() {
		assertEquals(productId, productPrice.getProductId());
	}

	@Test
	public void testGetPrice() {
		assertEquals(value, productPrice.getPrice());
	}

	@Test
	public void testGetCurrencyCode() {
		assertEquals(USD, productPrice.getCurrencyCode());
	}

}
