package com.tw.apistackbase.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private int companyId;
	private String companyName;
	private int employeesNumber;
	private List<Employee> employees = new ArrayList<Employee>();

	public Company() {}

	public Company(int companyId, String companyName, int employeesNumber, List<Employee> employees) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.employeesNumber = employeesNumber;
		this.employees = employees;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}

