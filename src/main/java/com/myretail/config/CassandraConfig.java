package com.myretail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories("dao")
public class CassandraConfig extends AbstractCassandraConfiguration {
	
	@Value("${cassandra.server}")
	String server;
	
	@Value("${cassandra.keyspace}")
	String keySpace;
	
	@Value("${cassandra.port}")
	int port;

	@Bean
	@Override
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(server);
		cluster.setPort(port);
		return cluster;
	}

	@Override
	public String getKeyspaceName() {
		return keySpace;
	}

	@Bean
	@Override
	public CassandraMappingContext cassandraMapping()
			throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}

}