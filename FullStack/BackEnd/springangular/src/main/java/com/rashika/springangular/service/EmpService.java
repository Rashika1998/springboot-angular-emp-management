package com.rashika.springangular.service;
import com.rashika.springangular.model.Employee;
import java.util.List;

public interface EmpService {
    public List<Employee> getEmployees();

    public Employee getEmployee(Long id);

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Long id, Employee employee);

    public void deleteEmployee(Long id);
}
