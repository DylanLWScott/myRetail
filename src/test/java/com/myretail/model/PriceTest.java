package com.myretail.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class PriceTest {
	
	private Price price;
	private BigDecimal value;
	private static final String USD = "USD";

	@Before
	public void setUp() throws Exception {
		price = new Price();
		value = new BigDecimal(10.00);
	}

	@Test
	public void testGetValue() {
		price.setValue(value);
		assertEquals(value, price.getValue());
	}

	@Test
	public void testGetCurrencyCode() {
		price.setCurrencyCode(USD);
		assertEquals(USD, price.getCurrencyCode());
	}

}
