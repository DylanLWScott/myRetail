package com.myretail.delegates;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.myretail.model.Item;
import com.myretail.model.ProductCompositeResponse;
import com.myretail.model.ProductName;
import com.myretail.model.ProductPrice;
import com.myretail.services.ProductNameService;
import com.myretail.services.ProductPriceService;

@RunWith(MockitoJUnitRunner.class)
public class ProductsDelegateTest {

	@Mock
	private ProductPriceService productPriceService;
	
	@Mock
	private ProductNameService productNameService;
	
	@InjectMocks
	private ProductsDelegate productsDelegate;
	
	private BigDecimal price = new BigDecimal(11.0);
	
	@Test
	public void testGetProductInformationById() {
		ProductPrice productPrice = new ProductPrice();
		productPrice.setCurrencyCode("USD");
		productPrice.setPrice(price);
		productPrice.setProductId(10L);
		ProductName productName = new ProductName();
		ProductCompositeResponse product_composite_response = new ProductCompositeResponse();
		List<Item> items = new ArrayList<Item>(1);
		Item item = new Item();
		item.setGeneral_description("desc");
		items.add(item);
		product_composite_response.setItems(items);
		productName.setProduct_composite_response(product_composite_response);
		when(productNameService.findNameByProductId(10L)).thenReturn(productName);
		when(productPriceService.findPriceByProductId(10L)).thenReturn(productPrice);
		productsDelegate.getProductInformationById(10L);
		verify(productNameService).findNameByProductId(10L);
		verify(productPriceService).findPriceByProductId(10L);
		
	}

	@Test
	public void testUpdateProductPriceById() {
		productsDelegate.updateProductPriceById(10L, price);
		verify(productPriceService).updatePriceByProductId(10L, price);
	}

}
