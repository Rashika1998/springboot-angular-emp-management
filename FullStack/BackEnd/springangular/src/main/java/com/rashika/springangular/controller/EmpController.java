package com.rashika.springangular.controller;
import com.rashika.springangular.model.Employee;
import com.rashika.springangular.repository.EmpRepository;
import com.rashika.springangular.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpController {

    @Autowired
    private EmpService empService;
    
    @GetMapping("/all")
    public List<Employee> getEmployees(){
        return empService.getEmployees();
    }

    @GetMapping("find/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return empService.getEmployee(id);
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return empService.saveEmployee(employee);
    }

    @PutMapping("/edit/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return empService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("id") Long id){

        empService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}
