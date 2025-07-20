package com.rgassignments.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration // Marks this class as a Spring configuration class
@ComponentScan(basePackages = "com.rgassignments.employee") // Scans for @Component, @Service, @Repository
public class AppConfig {

    @Bean // Defines a bean for the DataSource
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver"); // H2 database driver
        // In-memory H2 database. DB_CLOSE_DELAY=-1 keeps the DB alive as long as JVM is running.
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean // Defines a bean for JdbcTemplate, injecting the DataSource
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}