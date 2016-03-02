package com.myretail.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.myretail.model.ProductName;

@Component
public class ProductNameService {
	
	@Value("${product.name.url}")
	String url;
	
	@Value("${product.name.fields}")
	String fields;
	
	@Value("${product.name.idtype}")
	String idtype;
	
	@Value("${product.name.key}")
	String key;

	private RestTemplate restTemplate = new RestTemplate();
	
	public ProductName findNameByProductId(Long productId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path(Long.toString(productId, 10))
                .queryParam("id_type", idtype)
                .queryParam("key", key)
                .queryParam("fields", fields);


        ResponseEntity<ProductName> productName = restTemplate.getForEntity(builder.build().encode().toUri(), ProductName.class);
        if (productName.getStatusCode() == HttpStatus.OK) {
        	return productName.getBody();
        } else {
        	throw new RuntimeException();
        }
	}

}
