package com.tw.apistackbase.controller;

import com.github.pagehelper.PageHelper;
import com.tw.apistackbase.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeController(){
        employees.add(new Employee(1,"小明",23,"男",8000));
        employees.add(new Employee(2,"小红",26,"女",9000));
        employees.add(new Employee(3,"小智",21,"男",7000));
        employees.add(new Employee(4,"jerry",15,"男",5000));
        employees.add(new Employee(5,"sherry",16,"女",6000));
        employees.add(new Employee(6,"tom",17,"男",7000));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees(){
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOneEmployee(@PathVariable int id ){
        for (Employee employee : employees){
            if(employee.getId() == id){
                return ResponseEntity.ok(employee);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployeesByPageHelper(@RequestParam(defaultValue = "1") int pageNum,
                                                                      @RequestParam(defaultValue = "5") int pageSize
                                                                     )
    {
        PageHelper.startPage(pageNum, pageSize);
        if ((pageNum-1)*pageSize>employees.size()-1){
            return ResponseEntity.ok(null);
        }else if(pageNum*pageSize <= employees.size()-1){
            return ResponseEntity.ok(employees.subList((pageNum-1)*pageSize,pageNum*pageSize));
        }else {
            return ResponseEntity.ok(employees.subList((pageNum-1)*pageSize,employees.size()-1));
        }
    }

    @GetMapping("/male")
    public ResponseEntity<List<Employee>> getAllEmployeesByPageHelper(@RequestParam String gender)
    {
        List<Employee> maleGender = new ArrayList<>();
        for (Employee employee : employees){
            if(employee.getGender().equals(gender)){
                maleGender.add(employee);
            }
        }
        return ResponseEntity.ok(maleGender);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> creatEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateCompany(@PathVariable int id,
                                                  @RequestBody Employee newEmployee)
    {
        for(Employee employee : employees){
            if(employee.getId()== id){
                employee.setId(newEmployee.getId());
                employee.setName(newEmployee.getName());
                employee.setGender(newEmployee.getGender());
                employee.setSalary(newEmployee.getSalary());
                return ResponseEntity.ok(employee);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteCompany(@PathVariable int id)
    {
        for(Employee employee : employees){
            if(employee.getId() == id){
                employees.remove(employee);
                return ResponseEntity.ok(null);
            }
        }
        return ResponseEntity.notFound().build();
    }



}
