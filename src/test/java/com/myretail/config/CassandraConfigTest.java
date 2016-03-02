package com.myretail.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.test.util.ReflectionTestUtils;

public class CassandraConfigTest {
	
	private CassandraConfig config = new CassandraConfig();

	
	@Before
	public void setUp() {
		ReflectionTestUtils.setField(config, "server", "localhost");
		ReflectionTestUtils.setField(config, "keySpace", "myretail");
		ReflectionTestUtils.setField(config, "port", 17);
	}
	
	@Test
	public void testKeyspaceName() {
		assertEquals("myretail", config.getKeyspaceName());
	}
	
	@Test
	public void testBasicCassandraMappingContext() throws ClassNotFoundException {
		assertTrue(BasicCassandraMappingContext.class == config.cassandraMapping().getClass());
	}
	
	@Test
	public void testCluster() throws ClassNotFoundException {
		CassandraClusterFactoryBean cluster = config.cluster();
		assertNotNull(cluster);
	}

}
