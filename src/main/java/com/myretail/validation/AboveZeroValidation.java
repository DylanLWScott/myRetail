package com.myretail.validation;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class AboveZeroValidation {
	public boolean aboveZero(Long number) {
		boolean result = true;
		if (number < 0) {
			throw new RuntimeException("Product Id must be non-negative");
		}
		return result;
	}
	
	public boolean aboveZero(BigDecimal number) {
		boolean result = true;
		if (number.signum() == -1) {
			throw new RuntimeException("Price must be non-negative");
		}
		return result;
	}
}
