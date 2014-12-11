package ch.hfict.executer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration	 
	public class AppConfig {
	 
	@Bean(initMethod = "migrate")
	Flyway flyway() {
	Flyway flyway = new Flyway();
	flyway.setBaselineOnMigrate(true);
	flyway.setLocations("filesystem:src/main/resources/db/migration");
	flyway.setLocations("classpath:src/main/java/db.migration");
	flyway.setDataSource(dataSource());
	return flyway;
	}
	 
	@Bean @DependsOn("flyway")
	EntityManagerFactory entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
	bean.setDataSource(dataSource());
	// other configurations
	return bean.getObject();
	}
	 
	@Bean
	DataSource dataSource() {
	DataSource dataSource = new BasicDataSource();
	// data source configuration
	return dataSource;
	}
	}