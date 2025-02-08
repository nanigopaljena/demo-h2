package com.sample.reactive.demo.service;

import com.sample.reactive.demo.domain.Employee;
import com.sample.reactive.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Flux<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Mono<Employee> getById(Long id){
        return employeeRepository.findById(id);
    }

    public Flux<Employee> getAllNonBlocking() {
        // Start time measurement

        return employeeRepository.findAll()
                .map(employee -> {
                    // Non-blocking processing (e.g., transforming employee data)
                    employee.setName(employee.getName().toUpperCase());  // Example of processing
                    return employee;
                })
                .doOnTerminate(() -> {

                });
    }

    // Simulate blocking service for comparison
//    public List<Employee> getAllBlocking() {
//        long start = System.currentTimeMillis();  // Start time measurement
//        List<Employee> empList = new ArrayList<>();
//       return employeeRepository.findAll()
//               .flatMap(data->{
//                   return data;
//               })
//               .collect(Collectors.toList());
//        long end = System.currentTimeMillis();
//        System.out.println("Regular processing took: " + (end - start) + "ms");
//        return empList;
//    }

}
