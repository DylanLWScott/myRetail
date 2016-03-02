package com.myretail.services;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myretail.data.ProductPriceDao;
import com.myretail.model.ProductPrice;

@Component
public class ProductPriceService {
	
	private final Logger logger = LoggerFactory.getLogger("ProductPriceService");
	
	@Autowired
	ProductPriceDao productPriceDao;

	public ProductPrice findPriceByProductId(Long productId) {
		try {
			return productPriceDao.getPriceById(productId);
		} catch (Exception e) {
			logger.warn("Price DAO had an exception with message: {}", e.getMessage());
		}
		return null;
	}
	
	public void updatePriceByProductId(Long productId, BigDecimal price) {
		try {
			productPriceDao.updatePriceById(productId, price);
		} catch (Exception e) {
			logger.warn("Price Update had an exception with message: {}", e.getMessage());
		}
	}
}
