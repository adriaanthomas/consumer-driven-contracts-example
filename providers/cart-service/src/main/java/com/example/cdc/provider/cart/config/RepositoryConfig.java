package com.example.cdc.provider.cart.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.cdc.provider.cart")
@EnableAutoConfiguration
@EntityScan(basePackages = "com.example.cdc.provider.cart")
public class RepositoryConfig {
}
