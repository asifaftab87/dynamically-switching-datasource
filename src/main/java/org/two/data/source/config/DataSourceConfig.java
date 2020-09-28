package org.two.data.source.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.two.data.source.model.ModifyDBDetails;
import org.two.data.source.model.ReadDBDetails;

@Configuration

@EnableJpaRepositories(
		basePackages = "org.two.data.source.repository",
		transactionManagerRef = "transcationManager",
		entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {

	@Autowired
	private ModifyDBDetails modifyDBDetails;
	
	@Autowired
	private ReadDBDetails readDBDetails;
	
	@Bean
	@Primary
	@Autowired
	public DataSource dataSource() {
		DataSourceRouting routingDataSource = new DataSourceRouting();
		routingDataSource.initDatasource(modifyDataSource(),
				readDataSource());
		return routingDataSource;
	}

	public DataSource readDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(readDBDetails.getUrl());
		dataSource.setUsername(readDBDetails.getUsername());
		dataSource.setPassword(readDBDetails.getPassword());
		return dataSource;
	}
	
	public DataSource modifyDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(modifyDBDetails.getUrl());
		dataSource.setUsername(modifyDBDetails.getUsername());
		dataSource.setPassword(modifyDBDetails.getPassword());
		return dataSource;
	}

	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource()).packages("org.two.data.source")
				.build();
	}

	@Bean(name = "transcationManager")
	public JpaTransactionManager transactionManager(
			@Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		return new JpaTransactionManager(entityManagerFactoryBean.getObject());
	}
	
}
