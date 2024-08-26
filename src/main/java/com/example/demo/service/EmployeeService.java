package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.entity.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAllOrderByAppointmentCountAsc() {
        return employeeRepository.findAllOrderByAppointmentCountAsc();
    }
}
