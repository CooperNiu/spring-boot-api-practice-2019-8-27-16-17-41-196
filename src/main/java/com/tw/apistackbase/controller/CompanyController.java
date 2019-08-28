package com.tw.apistackbase.controller;


import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private List<Company> companies = new ArrayList<>();

    public CompanyController(){
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee(1,"小明",23,"男",8000));
        employees1.add(new Employee(2,"小红",26,"女",9000));
        employees1.add(new Employee(3,"小智",21,"男",7000));
        this.companies.add(new Company(1,"zybank", employees1.size(), employees1));

        List<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee(4,"jerry",15,"男",5000));
        employees2.add(new Employee(5,"sherry",16,"女",6000));
        employees2.add(new Employee(6,"tom",17,"男",7000));
        this.companies.add(new Company(2,"thoughtworks", employees2.size(), employees2));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getCompanies(){
        return companies;
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company>  getOneCompany(@PathVariable int companyId ){
        for (Company company : companies){
            if(company.getCompanyId() == companyId){
                return ResponseEntity.ok(company);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{companyId}/employees")
    public ResponseEntity<List<Employee>>  getOneCompanyEmployees(@PathVariable int companyId ){
        for (Company company : companies){
            if(company.getCompanyId() == companyId){
                return ResponseEntity.ok(company.getEmployees());
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<List<Company>> getAllCompaniesByPageHelper(@RequestParam(defaultValue = "1") int pageNum,
                                                                     @RequestParam(defaultValue = "5") int pageSize
                                                                     )
    {
        // PageHelper.startPage(pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        if ((pageNum-1)*pageSize>companies.size()-1){
            return ResponseEntity.ok(null);
        }else if(pageNum*pageSize <= companies.size()-1){
            return ResponseEntity.ok(companies.subList((pageNum-1)*pageSize,pageNum*pageSize));
        }else {
            return ResponseEntity.ok(companies.subList((pageNum-1)*pageSize,companies.size()-1));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Company> creatCompany(@RequestBody Company company){
        companies.add(company);
        return ResponseEntity.ok(company);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable int companyId,
                                                 @RequestBody Company newCompany)
    {
        for(Company company : companies){
            if(company.getCompanyId() == companyId){
                company.setCompanyId(newCompany.getCompanyId());
                company.setCompanyName(newCompany.getCompanyName());
                company.setEmployeesNumber(newCompany.getEmployeesNumber());
                company.setEmployees(newCompany.getEmployees());
                return ResponseEntity.ok(company);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Company> deleteCompany(@PathVariable int companyId)
    {
        for(Company company : companies){
            if(company.getCompanyId() == companyId){
                companies.remove(company);
                return ResponseEntity.ok(null);
            }
        }
        return ResponseEntity.notFound().build();
    }


}
