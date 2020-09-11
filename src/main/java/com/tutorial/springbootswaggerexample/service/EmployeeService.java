package com.tutorial.springbootswaggerexample.service;

import com.tutorial.springbootswaggerexample.entity.Employee;
import com.tutorial.springbootswaggerexample.repository.EmployeeRepository;

public interface EmployeeService {

    public Iterable<Employee> all();

    public Employee findEmployeeById(Long id);

    public Employee save(Employee employee);

    public void delete(Employee employee);
}