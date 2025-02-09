package com.sample.reactive.demo.config;

import com.sample.reactive.demo.domain.Employee;
import com.sample.reactive.demo.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;

	@Autowired
	public DatabaseLoader(EmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Scheduled(initialDelay = 1000, fixedRate = Long.MAX_VALUE)
    public void runOnceAfterStartup() {
		log.info("App has started, running one-time task");
		for(int i=0;i<100;i++){
			repo.save(new Employee("Employee ---"+i)).block();
		}
		log.info("Data load ended");

    }


}
