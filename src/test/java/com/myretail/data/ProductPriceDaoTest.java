package com.myretail.data;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.myretail.config.CassandraConfig;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceDaoTest {
	
	@Mock
	private CassandraConfig config;
	
	@Mock
	private Cluster cluster;
	
	@Mock
	private Session session;

	@Mock
	private PreparedStatement preparedSelect;
	
	@Mock
	private PreparedStatement preparedUpdate;
	
	@InjectMocks
	private ProductPriceDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new ProductPriceDao();
		ReflectionTestUtils.setField(dao, "config", config);
		ReflectionTestUtils.setField(dao, "priceSelect", "select price, currency_code from products where productid=? LIMIT 1");
		ReflectionTestUtils.setField(dao, "priceUpdate", "update products set price=? where productid=?");
		ReflectionTestUtils.setField(dao, "cluster", cluster);
		ReflectionTestUtils.setField(dao, "session", session);
		ReflectionTestUtils.setField(dao, "preparedSelect", preparedSelect);
		ReflectionTestUtils.setField(dao, "preparedUpdate", preparedUpdate);
	}

	
	@Test
	public void testCleanup() {
		ReflectionTestUtils.invokeMethod(dao, "cleanup");
		verify(session).close();
		verify(cluster).close();
	}


}
