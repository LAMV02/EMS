package com.example.demo.controller;


import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    //Build Add Employer
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmploye =  employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmploye, HttpStatus.CREATED);
    }

    //Build Get Employer By Id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeedId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeedId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto> employees = employeeService.getAllEmployees();
       return ResponseEntity.ok(employees);

    }

    //Build Update Employee
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeId, @RequestBody EmployeeDto updateEmployee){
            EmployeeDto employeeDto= employeeService.updateEmployee(employeId, updateEmployee);
            return  ResponseEntity.ok(employeeDto);
    }

    //Buid Delete Employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable("id") Long employeId){
        employeeService.deleteEmploye(employeId);
        return ResponseEntity.ok("Employee Deleted Succesfully");
    }

}
