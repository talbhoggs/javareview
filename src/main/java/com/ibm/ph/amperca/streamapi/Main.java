package com.ibm.ph.amperca.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {
	public static void staticMethodReference() {
		System.out.println("STATIC METHOD REFERENCE");
	}
	
	
	public static void main(String[] args) {
		
		// Stream pipeline is consist of the following:
		// A source
		// 0 of more intermediate operation -> map, filter
		// one terminal -> forEach
		
		List<String> names = new LinkedList<>();
		names.add("Charles");
		names.add("Amber");
		names.add("Joy");
		names.add("Eric");
		
		names.stream().forEach(name -> System.out.println(name));
		
		Predicate<String> pre = p -> p.equals("Amber");

		names.stream().filter(pre).forEach(name -> System.out.println(" >>>>  " + name));
		
		// Lamda vs method references
		// 
		// Lamda : .foreach(t -> t.print());
		
		// Method references
		//
		// 1. Reference to static method -> ContainingClass::staticMethod
		// 2. Reference to instance method -> String::compareToIgnoreCase
		// 3. Reference to Constructor -> ClassName::new
		
		// Predicate has a test method that accept a T and return a boolean
		
		// Consumer 
		// - mostly put in the terminal operation
		
		/*
		 * public interface Consumer<T> {
		 * 	public void accept(T t);
		 * }
		 * 
		 * */
		
		// Function
		/*
		 * 
		 * public interface Function<T, R> {
		 * 	public R apply(T t)
		 * }
		 * 
		 * 
		 * */
		
		// Supplier
		/*
		 * public interface Supplier<T> {
		 * 
		 * 	public T get();
		 * }
		 * 
		 * 
		 * */
		
		// Take note of autoboxing in streams as it will degrade your
		
		// Stream data Methods

		// Min , Max, Count
		
		// Search method
		
		// findAny, findFirst
		
		// Sorting methods
		
		// sorted
		
		// Comparator.comparing(<>).thenComparing(<>) // multiple sort
		
		
		// Map
		// extract data from the field and perform calculation
		
		
		// Managing data stream
		// allows you to save the result of the stream to a new data structure
		// .collect(Collectors.toList)
		
		// joining, groupingBy , partitioningBy, 
		
		List<Employee> listEmployees = new ArrayList<>();
		
		listEmployees.add(new Employee(1, "Charles","Amper",38,300, "developer"));
		listEmployees.add(new Employee(2, "Mary Joy","Bonita",31,7700, "developer"));
		listEmployees.add(new Employee(3, "Eric","Austria",21,100, "developer"));
		listEmployees.add(new Employee(4, "Devon","Zimmerman",38,1300, "tester"));
		listEmployees.add(new Employee(5, "Arnold","Nigen",33,3000,"manager"));
		listEmployees.add(new Employee(6, "Ben","Zimmerman",33,4000, "manager"));
		Optional<Employee> em = listEmployees.stream().filter(p -> p.getLastName().equals("Zimmerman")).findFirst();
		Optional<Employee> em1 = listEmployees.stream().filter(p -> p.getLastName().equals("Zimmerman")).findAny();
		
		Optional<Employee> em2 = listEmployees.stream().max(Comparator.comparing(Employee::getSalary));
		Optional<Employee> em3 = listEmployees.stream().min(Comparator.comparing(Employee::getSalary));
		
		System.out.println("===================Sort by first name DESC");
		listEmployees.stream().sorted(Comparator.comparing(Employee::getFirstName)).forEach(p->System.out.println(p.getFirstName() + " " + p.getLastName()));
		System.out.println("===================Sort by first name ASC");
		listEmployees.stream().sorted(Comparator.comparing(Employee::getFirstName).reversed()).forEach(p->System.out.println(p.getFirstName() + " " + p.getLastName()));

		System.out.println("===================First, Any");
		System.out.println("find first => " + em.get().getFirstName() + " " + em.get().getLastName());
		System.out.println("find any => " + em1.get().getFirstName() + " " + em1.get().getLastName());
		System.out.println("===================First, Any");
		System.out.println("find max => " + em2.get().getFirstName() + " " + em2.get().getLastName());
		System.out.println("find min => " + em3.get().getFirstName() + " " + em3.get().getLastName());
		System.out.println("===================MAP TOTAL Salary Employee	");
		listEmployees.stream().map(p -> p.getSalary() * 12).forEach(p->System.out.println("Total Salary (in a yr) : " + p));
		
		System.out.println("===================MAP");
		
		listEmployees.stream().map(p->p.getFirstName() + " " + p.getLastName()).forEach(System.out::println);
		
		
		System.out.println("===================LIST");
		
		
		List<Employee> list = listEmployees.stream().collect(Collectors.toList());
		System.out.println(list);
		System.out.println("===================SET");
		Set<Employee> set = listEmployees.stream().collect(Collectors.toSet());
		System.out.println(set);
		System.out.println("===================MAP");
		Map<Integer, Employee> maplist = listEmployees.stream().collect(Collectors.toMap(Employee::getId, p->p));
		System.out.println(maplist);
		System.out.println("===================GROUP BY");
		
		Map<String, List<Employee>> mapEmp = list.stream().collect(Collectors.groupingBy(e -> e.getPosition()));
		
		mapEmp.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
		
		mapEmp.values().stream().forEachOrdered(p->{
			System.out.println(p);
		});
		
	}
}


