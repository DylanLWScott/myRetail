package com.myretail.it;

import java.math.BigDecimal;

import net.serenitybdd.core.Serenity;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.myretail.model.ProductInformationResponse;

@Component
public class IntegrationTestState {
	
	public void clear() {
		Serenity.getCurrentSession().clear();
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getFromSession(String key) {
		try {
			return (T) Serenity.getCurrentSession().get(key);
		} catch (Exception e) {
			return null; 
		}
	}
	
	private void putInSession(String key, Object value) {
		Serenity.getCurrentSession().put(key, value);
	}
	
	public void setProductId(Long id) {
		putInSession("productId", id);
	}
	
	public Long getProductId() {
		return getFromSession("productId");
	}
	
	public void setHttpClientErrorException(HttpClientErrorException exception) {
		putInSession("clientException", exception);
	}
	
	public HttpClientErrorException getHttpClientErrorException() {
		return getFromSession("clientException");
	}
	
	public void setProductInformationResponse(ProductInformationResponse res) {
		putInSession("productInformationResponse", res);
	}
	
	public ProductInformationResponse getProductInformationResponse() {
		return getFromSession("productInformationResponse");
	}
	
	public void setPrice(BigDecimal price) {
		putInSession("price", price);
	}
	
	public BigDecimal getPrice() {
		return getFromSession("price");
	}

}
