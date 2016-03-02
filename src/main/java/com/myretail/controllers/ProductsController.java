package com.myretail.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.delegates.ProductsDelegate;
import com.myretail.model.ProductInformationResponse;
import com.myretail.validation.AboveZeroValidation;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsDelegate productsDelegate;
	
	@Autowired
	private AboveZeroValidation aboveZeroValidation;

	@RequestMapping(value="/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProductPrice(@PathVariable(value="id") Long productId, @RequestBody(required = true) BigDecimal price) {
		aboveZeroValidation.aboveZero(productId);
		aboveZeroValidation.aboveZero(price);
		productsDelegate.updateProductPriceById(productId, price);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ProductInformationResponse retrieveProductInformation(@PathVariable(value="id") Long productId)  {
		aboveZeroValidation.aboveZero(productId);
		return productsDelegate.getProductInformationById(productId);
	}
	
}
