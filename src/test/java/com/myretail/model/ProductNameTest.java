package com.myretail.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductNameTest {
	
	private ProductName productName;
	private ProductCompositeResponse response;

	@Before
	public void setUp() throws Exception {
		productName = new ProductName();
		response = new ProductCompositeResponse();
	}

	@Test
	public void testGetProduct_composite_response() {
		productName.setProduct_composite_response(response);
		assertEquals(response, productName.getProduct_composite_response());
	}

}
