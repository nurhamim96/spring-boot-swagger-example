package com.tutorial.springbootswaggerexample.controller;

import com.tutorial.springbootswaggerexample.entity.Employee;
import com.tutorial.springbootswaggerexample.service.EmployeeServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @ApiOperation("value")
    @RequestMapping(method = RequestMethod.GET, value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Employee> employee(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ApiOperation("value")
    @RequestMapping(method = RequestMethod.GET, value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Iterable<Employee>> employees() {
        Iterable<Employee> employees = employeeService.all();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Employee> createProject(@RequestBody Employee emp) {
        Employee employee = employeeService.save(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Boolean> deleteProject(@RequestBody Employee emp) {
        employeeService.delete(emp);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}