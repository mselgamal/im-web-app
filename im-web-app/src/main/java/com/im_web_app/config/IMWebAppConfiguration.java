package com.im_web_app.config;


import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.im_web_app")
@PropertySource("classpath:persistence-mysql.properties")
public class IMWebAppConfiguration implements WebMvcConfigurer{
	
	// represents enviroment vars extracted from properties file
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// db connection setup
	@Bean
	public DataSource dataSource() {
		// create connection pool
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// set jdbc driver
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		logger.info(">>> JDBC.url: " + env.getProperty("jdbc.url"));
		logger.info(">>> JDBC.user: " + env.getProperty("jdbc.user"));
		
		// set database connection properties
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		dataSource.setInitialPoolSize(Integer.parseInt(
				env.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMinPoolSize(Integer.parseInt(
				env.getProperty("connection.pool.minPoolSize")));
		dataSource.setMaxPoolSize(Integer.parseInt(
				env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMaxIdleTime(Integer.parseInt(
				env.getProperty("connection.pool.maxIdleTime")));
		
		return dataSource;
	}
	
	// sesssion factory
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(HibernateConfig config, DataSource dataSource) {
		Properties hibernateProp = new Properties();
		hibernateProp.setProperty("hibernate.dialect", config.getDialect());
		hibernateProp.setProperty("hibernate.show_sql", String.valueOf(config.isShowSql()));
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(hibernateProp);
		sessionFactory.setPackagesToScan(new String[] {"com.im_web_app.entity"});
		
		return sessionFactory;		
	}
	
	// transaction manager
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	// view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// add static resources path, for js/css/imgs etc
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
}
