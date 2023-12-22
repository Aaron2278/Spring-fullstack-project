package com.codedifferently.fullstackspring.domain.employee.services;

import com.codedifferently.fullstackspring.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.fullstackspring.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.fullstackspring.domain.employee.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee) throws ResourceCreationException;
    Employee getById(Long id) throws ResourceCreationException;
    Employee getByEmail(String email) throws ResourceNotFoundException;
    List<Employee> getAll();
    Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException;
    void delete(Long id);

}
