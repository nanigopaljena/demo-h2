package com.sample.reactive.demo.repository;

import com.sample.reactive.demo.domain.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {


}
