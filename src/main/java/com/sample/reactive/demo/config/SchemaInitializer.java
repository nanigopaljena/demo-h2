package com.sample.reactive.demo.config;

import com.sample.reactive.demo.domain.Employee;
import com.sample.reactive.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
@Slf4j
public class SchemaInitializer {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    public SchemaInitializer(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Bean
    public ApplicationRunner runner(DatabaseClient databaseClient) {

        return args -> {
            // SQL to create tables if they don't exist
            databaseClient.sql("CREATE TABLE IF NOT EXISTS employee (" +
                            "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                            "name VARCHAR(255), " +
                            "email VARCHAR(255)" +
                            ")")
                    .then()
                    .block();  // Block here to make it synchronous for schema initialization
        };




    }


}
