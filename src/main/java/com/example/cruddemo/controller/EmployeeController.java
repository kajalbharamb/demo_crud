package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.HyperlinkEvent;
import javax.validation.Valid;
import java.util.List;
@ControllerAdvice
@RestController
// this will talk to this class
public class EmployeeController  {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Employee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.ACCEPTED);
    }

    @PostMapping("/Employees")
    public ResponseEntity<List<Employee>> addEmployee(@Valid @RequestBody List<Employee> employees){
        return new ResponseEntity<List<Employee>>(employeeService.saveEmployees(employees),HttpStatus.ACCEPTED);
    }

    @GetMapping("/Employees")
    public ResponseEntity<List<Employee>> findAllProducts(){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployee(),HttpStatus.OK);
    }

    @GetMapping("/EmployeeById/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/Employee/{name}")
    public ResponseEntity<Employee> findEmployeeByName(@PathVariable String name){
        return new ResponseEntity<Employee>(employeeService.getEmployeeName(name),HttpStatus.OK);
    }

    @PutMapping("/Employee")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){ return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.ACCEPTED);
    }
}