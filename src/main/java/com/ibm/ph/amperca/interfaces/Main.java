package com.ibm.ph.amperca.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	public static void main(String[] args) {
		Employee em = new Employee("Charles Amper", "developer", 51000d);
		Employee em1 = new Employee("Nicandro Amper", "manager", 150000d);
		Employee em2 = new Employee("Lawrence Amper", "developer", 20000d);
		Employee em3 = new Employee("Eric Amper", "developer", 30000d);
		Employee em4 = new Employee("Lorna Amper", "manager", 90000d);
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(em);
		employeeList.add(em1);
		employeeList.add(em2);
		employeeList.add(em3);
		employeeList.add(em4);
		
		employeeList.forEach(p -> Report.printReport(p));
	}

}

// all methods are public no private
// variables are constant
interface TotalSalary {
	public Double totalYearlySalary();
	public Double bonuses();
}

class Employee implements TotalSalary{
	public Employee() {}
	public Employee(String name, String role, Double salary) {
		super();
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	private String name;
	private String role;
	private Double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public Double totalYearlySalary() {
		return (salary * 12) + bonuses();
	}
	@Override
	public Double bonuses() {
		return salary * 2;
	}
}


class Report {
	public static void printReport(Employee employee) {
		System.out.println("Employee name " + employee.getName() + " " + "Total salary (yr) " + employee.totalYearlySalary());
	}
}

