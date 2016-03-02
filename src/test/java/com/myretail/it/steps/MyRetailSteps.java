package com.myretail.it.steps;

import java.math.BigDecimal;
import java.net.URI;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.myretail.model.ProductInformationResponse;

@Component
public class MyRetailSteps {
	
	@Autowired
	private RestTemplate rest;
	
	@Resource(name="productsUrl")
	private URI productsUrl;
	
	public ProductInformationResponse getInformationById(Long productId) {
		ResponseEntity<String> response = rest.getForEntity(productsUrl+ "/" + productId, String.class);
		return new Gson().fromJson(response.getBody(),ProductInformationResponse.class);
	}
	
	public ProductInformationResponse getPriceUpdateById(Long productId, BigDecimal price) {
		rest.put(productsUrl+ "/" + productId, price);
		ResponseEntity<String> response = rest.getForEntity(productsUrl+ "/" + productId, String.class);
		return new Gson().fromJson(response.getBody(),ProductInformationResponse.class);
	}
}
