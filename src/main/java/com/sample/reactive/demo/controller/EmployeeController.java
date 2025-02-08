package com.sample.reactive.demo.controller;

import com.sample.reactive.demo.domain.Employee;
import com.sample.reactive.demo.repository.EmployeeRepository;
import com.sample.reactive.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/get-all-non-blocking")
    public Flux<Employee> getAllNonBlocking(){
        long start = System.currentTimeMillis();
        Flux<Employee> resp =  service.getAllNonBlocking();
        long end = System.currentTimeMillis();  // End time measurement
        System.out.println("Non-blocking processing took: " + (end - start) + "ms");
        return resp;
    }

    @GetMapping("/{id}")
    public Mono<Employee> getAll(@PathVariable Long id){
        return service.getById(id);
    }


}
