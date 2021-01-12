package com.example.restservice;

import org.springframework.web.client.RestTemplate;

public class Employee {
	private	int id;
	private String name;
	private String contractTypeName;
	private int roleId;
	private String roleName;
	private Double hourlySalary;
	private Double monthlySalary;
	private Double annualSalary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContractTypeName() {
		return contractTypeName;
	}
	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Double getHourlySalary() {
		return hourlySalary;
	}
	public void setHourlySalary(Double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}
	public Double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public Double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary() {
		if(this.contractTypeName.matches("HourlySalaryEmployee"))
			this.annualSalary = 120 * this.getHourlySalary() * 12;
		else
			this.annualSalary = this.getMonthlySalary() * 12;
	}
	
}
