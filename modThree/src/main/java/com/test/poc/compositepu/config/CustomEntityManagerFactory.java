package com.test.poc.compositepu.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"classpath:dbConf.properties"})
public class CustomEntityManagerFactory {

	public static final Logger LOG = LoggerFactory.getLogger(CustomEntityManagerFactory.class);

	@Value("${database.driver}")
	public String JDBC_DRIVER;
	@Value("${database.username}")
	public String DB_USERNAME;
	@Value("${database.password}")
	public String DB_PASSWORD;
	@Value("${database.host}")
	public String DB_HOST;
	@Value("${database.params}")
	public String DB_PARAMS;

	public static final String DB_ONE = "dbone";
	public static final String DB_TWO = "dbtwo";

	public static final String PU_ONE = "PUONE";
	public static final String PU_TWO = "PUTWO";
	public static final String COMPOSITE_PU = "CompositePU";

	public static final String JAVAX_PERSISTENCE_JDBC_USER = "javax.persistence.jdbc.user";
	public static final String JAVAX_PERSISTENCE_JDBC_PASSWORD = "javax.persistence.jdbc.password";
	public static final String JAVAX_PERSISTENCE_JDBC_DRIVER = "javax.persistence.jdbc.driver";
	public static final String JAVAX_PERSISTENCE_JDBC_URL = "javax.persistence.jdbc.url";

	public static final String ECLIPSELINK_COMPOSITE_UNIT_PROPERTIES = "eclipselink.composite-unit.properties";

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		
		LOG.info("-> propertyPlaceholderConfigurer");
		
		return new PropertySourcesPlaceholderConfigurer();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	protected EntityManagerFactory entityManagerFactory() throws PersistenceException {
		LOG.info("-> entityManagerFactory");
		Map<String, String> props1 = new HashMap<>();
		props1.put(JAVAX_PERSISTENCE_JDBC_USER, DB_USERNAME);
		props1.put(JAVAX_PERSISTENCE_JDBC_PASSWORD, DB_PASSWORD);
		props1.put(JAVAX_PERSISTENCE_JDBC_DRIVER, JDBC_DRIVER);
		props1.put(JAVAX_PERSISTENCE_JDBC_URL, DB_HOST + DB_ONE + DB_PARAMS);
		Map<String, String> props2 = new HashMap<>();
		props2.put(JAVAX_PERSISTENCE_JDBC_USER, DB_USERNAME);
		props2.put(JAVAX_PERSISTENCE_JDBC_PASSWORD, DB_PASSWORD);
		props2.put(JAVAX_PERSISTENCE_JDBC_DRIVER, JDBC_DRIVER);
		props2.put(JAVAX_PERSISTENCE_JDBC_URL, DB_HOST + DB_TWO + DB_PARAMS);

		Map<String, Map<String, String>> memberProps = new HashMap<>();
		memberProps.put(PU_ONE, props1);
		memberProps.put(PU_TWO, props2);
		Map props = new HashMap();
		props.put(ECLIPSELINK_COMPOSITE_UNIT_PROPERTIES, memberProps);
		props.put("eclipselink.logging.level", "FINEST");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(COMPOSITE_PU, props);

		LOG.info("<- entityManagerFactory emf.getProperties={}", emf.getProperties());
		return emf;
	}

}
