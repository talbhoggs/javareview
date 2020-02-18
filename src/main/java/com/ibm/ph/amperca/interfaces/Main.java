package com.ibm.ph.amperca.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

		System.out.println("------------------ funcitonal interace");

		class FunctionInterface1Impl implements FunctionalInterface1 {

			@Override
			public int calculate(int a, int b) {
				int add = sub(a, b);
				int result = FunctionalInterface1.multiply(add, 2);
				return result;
			}

		}

		FunctionalInterface1 add = (a, b) -> a + b;
		Main.add(10, 10, add);

		Predicate<Employee> predi = e -> e.getRole().equals("developer");
		boolean isTrue = predi.test(em);

		// accept a Type returns a boolean
		System.out.println("=========================================== PREDICATE");
		System.out.println("Employee " + em.getName() + " is a developer " + isTrue);

		System.out.println("=========================================== SUPPLIER");

		// accepts no parameter return a type
		List<Employee> employeeList1 = new ArrayList<>();
		Supplier<List<Employee>> sup = () -> {

			employeeList1.add(em);
			employeeList1.add(em1);
			employeeList1.add(em2);
			employeeList1.add(em3);
			employeeList1.add(em4);

			return employeeList1;
		};

		sup.get().stream().forEach(p -> System.out.println(" --> " + p.getName()));
		System.out.println("=========================================== CONSUMER");

		Consumer<List<Employee>> consume = e -> {
			Employee em5 = new Employee("Allen Montejo", "manager", 190000d);
			e.add(em5);
		};

		// accepts a type returns void
		consume.accept(employeeList1);
		employeeList1.stream().forEach(p -> System.out.println(" --> " + p.getName()));

		// accepts a type return a results
		Function<Employee, String> func = e -> e.getName();

		System.out.println("=========================================== FUNCTION");
		System.out.println("Name of em1 is " + func.apply(em1));

	}

	static int add(int a, int b, FunctionalInterface1 fun) {
		return fun.calculate(a, b);
	}

}

// all methods are public no private
// variables are constant
interface TotalSalary {
	public Double totalYearlySalary();

	public Double bonuses();
}

class Employee implements TotalSalary {
	public Employee() {
	}

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
		System.out.println(
				"Employee name " + employee.getName() + " " + "Total salary (yr) " + employee.totalYearlySalary());
	}
}

// functional interace are interface that has one method
@FunctionalInterface
interface FunctionalInterface1 {
	int calculate(int a, int b);

	// default interface
	default int sub(int a, int b) {
		return a - b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

}
