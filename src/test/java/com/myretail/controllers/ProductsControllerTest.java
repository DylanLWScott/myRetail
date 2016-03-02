package com.myretail.controllers;

import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.myretail.delegates.ProductsDelegate;
import com.myretail.validation.AboveZeroValidation;

@RunWith(MockitoJUnitRunner.class)
public class ProductsControllerTest {
	
	@Mock
	private ProductsDelegate productsDelegate;
	
	@Mock
	private AboveZeroValidation aboveZeroValidation;
    
	@InjectMocks
	private ProductsController productsController;

	@Test
	public void testUpdateProductPrice() {
		BigDecimal price = new BigDecimal(12.00);
		productsController.updateProductPrice(10l, price);
		verify(aboveZeroValidation).aboveZero(10L);
		verify(aboveZeroValidation).aboveZero(price);
		verify(productsDelegate).updateProductPriceById(10L, price);
	}

	@Test
	public void testRetrieveProductInformation() {
		productsController.retrieveProductInformation(10L);
		verify(aboveZeroValidation).aboveZero(10L);
		verify(productsDelegate).getProductInformationById(10L);
	}

}
