package com.myretail.data;

import java.math.BigDecimal;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.myretail.config.CassandraConfig;
import com.myretail.model.ProductPrice;

@Repository
public class ProductPriceDao  {
	
	@Value("${cassandra.priceselect}")
	private String priceSelect;
	
	@Value("${cassandra.priceupdate}")
	private String priceUpdate;
	
	@Autowired
	private CassandraConfig config;
	
	private Cluster cluster;
	private Session session;

	private PreparedStatement preparedSelect;
	private PreparedStatement preparedUpdate;

	@PostConstruct
	private void createSession() {
		try {
			cluster = config.cluster().getObject();
			session = cluster.connect(config.getKeyspaceName());
		} catch (Exception e) {
			throw new RuntimeException("Error connecting to database cluster");
		}
		preparedSelect = session.prepare(priceSelect);
		preparedUpdate = session.prepare(priceUpdate);
	}
	
	public ProductPrice getPriceById(long id) throws Exception {
		BoundStatement bound = preparedSelect.bind(id);
		ResultSet resultSet = session.execute(bound);
		Iterator<Row> iter = resultSet.iterator();
		BigDecimal res = null;
		String currency_code = null;
		while (iter.hasNext()) {
			Row r = iter.next();
			res = r.getDecimal("price");
			currency_code = r.getString("currency_code");
		}
		ProductPrice productPrice = new ProductPrice();
		productPrice.setPrice(res);
		productPrice.setCurrencyCode(currency_code);
		return productPrice;
	}
	
	public void updatePriceById(long id, BigDecimal price) throws Exception{
		BoundStatement bound = preparedUpdate.bind(price, id);
		session.execute(bound);
	}
	
	@PreDestroy
	private void cleanup() throws Exception {
		if (session != null) {
			session.close();
		}
		if (cluster != null) {
			cluster.close();
		}
	}


	
}

