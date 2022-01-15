package com.rashika.springangular.service;

import com.rashika.springangular.model.Employee;
import com.rashika.springangular.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public List<Employee> getEmployees() {
        return empRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return empRepository.findById(id).get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee empDb = empRepository.findById(id).get();

        if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())){
            empDb.setName(employee.getName());
        }

        if (Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
            empDb.setEmail(employee.getEmail());
        }

        if (Objects.nonNull(employee.getAge()) && !"".equalsIgnoreCase(employee.getAge())){
            empDb.setAge(employee.getAge());
        }

        return empRepository.save(empDb);
    }

    @Override
    public void deleteEmployee(Long id) {
        empRepository.deleteById(id);
    }
}
