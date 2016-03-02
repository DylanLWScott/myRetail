package com.myretail.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import springfox.documentation.spring.web.plugins.Docket;

import com.myretail.config.SwaggerConfig;

public class SwaggerConfigTest {

	@Test
	public void verifyDocket() {
		Docket docket = new SwaggerConfig().productsApi();
		assertNotNull(docket);
		assertEquals("myretail-product-api", docket.getGroupName());
	}

}
