package com.example.testTask.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class DatabaseConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource getDataSource() {
        String jndi = dataSourceProperties.getJndiName();
        String url = dataSourceProperties.getUrl();
        logger.debug("Configuring Datasource Url: {}. JNDI-name: {}.", url, jndi);
        if (url == null && jndi == null) {
            logger.error("Your database connection pool configuration is incorrect! The application" +
                            " cannot start. Please check your Spring profile, current profiles are: {}",
                    Arrays.toString(env.getActiveProfiles()));

            throw new ApplicationContextException("Database connection pool is not configured correctly. " +
                    "Datasource.url and Datasource.jndi-name is null");
        }

        HikariConfig config = new HikariConfig();

        if (!StringUtils.hasText(jndi)) {
            //smart driver class name detection
            //com.mysql.cj.jdbc.MysqlDataSource.class.getName()
            config.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
            config.addDataSourceProperty("url", url);
            config.setUsername(dataSourceProperties.getUsername());
            config.setPassword(dataSourceProperties.getPassword());
            config.addDataSourceProperty("tcpKeepAlive", true);
            config.setConnectionTestQuery("SELECT 1");
        } else {
            config.setDataSourceJNDI(dataSourceProperties.getJndiName());
        }

        HikariDataSource hikariDataSource;
        try {
            hikariDataSource = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException("Could not configure data source", e);
        }

        return hikariDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransaction = new JpaTransactionManager();
        jpaTransaction.setEntityManagerFactory(entityManagerFactory);
        return jpaTransaction;
    }
}
