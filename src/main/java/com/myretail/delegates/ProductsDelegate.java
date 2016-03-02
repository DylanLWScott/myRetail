package com.myretail.delegates;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myretail.model.Price;
import com.myretail.model.ProductInformationResponse;
import com.myretail.model.ProductName;
import com.myretail.model.ProductPrice;
import com.myretail.services.ProductNameService;
import com.myretail.services.ProductPriceService;

@Component
public class ProductsDelegate {
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@Autowired
	private ProductNameService productNameService;
	
	public ProductInformationResponse getProductInformationById(Long productId) {
		ProductPrice productPrice = retrievePrice(productId);
		ProductName productName = retrieveName(productId);
		return createOutputFormat(productPrice,productName, productId);
	}
	
	private ProductInformationResponse createOutputFormat(
			ProductPrice productPrice, ProductName productName, Long productId) {
		ProductInformationResponse productInformationResponse = new ProductInformationResponse();
		productInformationResponse.setId(productId);
		productInformationResponse.setName(productName.getProduct_composite_response().getItems().get(0).getGeneral_description());
		
		Price price = new Price();
		price.setValue(productPrice.getPrice());
		price.setCurrencyCode(productPrice.getCurrencyCode());
		productInformationResponse.setCurrent_Price(price);
		return productInformationResponse;
	}

	private ProductName retrieveName(Long productId) {
		return productNameService.findNameByProductId(productId);
	}

	private ProductPrice retrievePrice(Long productId) {
		return productPriceService.findPriceByProductId(productId);
	}

	public void updateProductPriceById(Long productId, BigDecimal price) {
		productPriceService.updatePriceByProductId(productId, price);
	}

}
