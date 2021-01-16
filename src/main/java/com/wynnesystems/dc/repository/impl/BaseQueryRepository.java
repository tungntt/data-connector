package com.wynnesystems.dc.repository.impl;

import com.wynnesystems.dc.domain.ConnectorEntity;
import com.wynnesystems.dc.service.dto.ConnectorDTO;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Properties;

public class BaseQueryRepository {

    private static final String JDBC_URL = "jdbc:%s://%s:%s/%s";

    public EntityManager getEntityManager(ConnectorDTO connector) {
        final LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.dataSource(connector));
        em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
        em.setJpaProperties(this.hibernateProperties(connector.getDbType()));
        em.setPersistenceUnitName("data-connector");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject().createEntityManager();
    }

    protected DataSource dataSource(ConnectorDTO connector) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(connector.getDbType().getDriverClassName());
        final String url = String.format(JDBC_URL, connector.getDbType().name().toLowerCase(),
                connector.getHost(), connector.getPort(), connector.getDbName());
        dataSource.setUrl(url);
        dataSource.setUsername(connector.getUsername());
        dataSource.setPassword(connector.getPassword());
        return dataSource;
    }

    protected Properties hibernateProperties(ConnectorEntity.DbType dbType){
        final Properties properties = new Properties();
        properties.put( "hibernate.dialect", dbType.getHibernateDialect() );
        properties.put( "hibernate.connection.driver_class", dbType.getDriverClassName() );
        properties.put( "hibernate.hbm2ddl.auto", "none" );
        return properties;
    }

}
