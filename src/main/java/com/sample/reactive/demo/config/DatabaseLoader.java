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

	@Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void runOnceAfterStartup() {
        // Your logic here to run once after application starts
        System.out.println("App has started, running one-time task...");
            log.debug("data getting inserted");
            repo.save(new Employee("Emp 1")).block();
            repo.save(new Employee("Emp 2")).block();
            repo.save(new Employee("Emp 3")).block();
            repo.save(new Employee("Emp 4")).block();
    }


}
