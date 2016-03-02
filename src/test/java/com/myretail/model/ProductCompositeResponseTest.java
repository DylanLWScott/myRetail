package com.myretail.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProductCompositeResponseTest {
	private ProductCompositeResponse res;
	private List<Item> items;

	@Before
	public void setUp() throws Exception {
		res = new ProductCompositeResponse();
		items = new ArrayList<Item>(1);
		res.setItems(items);
	}

	@Test
	public void testGetItems() {
		assertEquals(items, res.getItems());
	}

}
