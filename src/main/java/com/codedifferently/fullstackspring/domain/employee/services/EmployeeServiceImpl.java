package com.codedifferently.fullstackspring.domain.employee.services;

import com.codedifferently.fullstackspring.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.fullstackspring.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.fullstackspring.domain.employee.models.Employee;
import com.codedifferently.fullstackspring.domain.employee.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) throws ResourceCreationException {
        Optional<Employee> optional = employeeRepository.findByEmail(employee.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException(("Employee with email exists: " + employee.getEmail()));
        employee = employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getById(Long id) throws ResourceCreationException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Employee with id: " + id));
        return employee;
    }

    @Override
    public Employee getByEmail(String email) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Employee with email: " + email));
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
