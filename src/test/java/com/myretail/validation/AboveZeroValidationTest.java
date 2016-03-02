package com.myretail.validation;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AboveZeroValidationTest {
	
	private Long id;
	private BigDecimal price;
	private AboveZeroValidation aboveZeroValidation;
	
	@Before
	public void setUp() throws Exception {
		id = 10l;
		price = new BigDecimal(11.00);
		aboveZeroValidation = new AboveZeroValidation();
	}

	@Test
	public void testAboveZeroLong() {
		assertTrue(aboveZeroValidation.aboveZero(price));
	}

	public void testZeroLong() {
		assertTrue(aboveZeroValidation.aboveZero(0l));
	}
	
	public void testZeroBigDecimal() {
		assertTrue(aboveZeroValidation.aboveZero(new BigDecimal(0.0)));
	}
	
	@Test(expected=RuntimeException.class)
	public void testBelowZeroLong() {
		assertTrue(aboveZeroValidation.aboveZero(-1l));
	}
	
	@Test(expected=RuntimeException.class)
	public void testBelowZeroBigDecimal() {
		assertTrue(aboveZeroValidation.aboveZero(new BigDecimal(-1.0)));
	}

}
