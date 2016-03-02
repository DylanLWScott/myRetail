package com.myretail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductName {
	
	private ProductCompositeResponse product_composite_response;
	
	public ProductCompositeResponse getProduct_composite_response() {
		return product_composite_response;
	}

	public void setProduct_composite_response(
			ProductCompositeResponse product_composite_response) {
		this.product_composite_response = product_composite_response;
	}

}
