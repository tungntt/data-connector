package com.wynnesystems.dc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(value = "com.wynnesystems.dc.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
