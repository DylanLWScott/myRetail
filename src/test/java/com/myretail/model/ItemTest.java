package com.myretail.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
	@Test
	public void items() {
		Item item = new Item();
		item.setGeneral_description("desc");
		assertEquals("desc", item.getGeneral_description());
	}
}
