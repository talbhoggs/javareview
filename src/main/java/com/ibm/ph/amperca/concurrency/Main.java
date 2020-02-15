package com.ibm.ph.amperca.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	static void executorExample() {

		long startTime = System.nanoTime();

		System.out.println("start time : " + startTime);

		ExecutorService executor = Executors.newFixedThreadPool(6);

		List<Callable<String>> tasks = new ArrayList<>();

		for (int i = 0; i <= 10; i++) {
			tasks.add(new Task(i + ""));
		}
		try {
			executor.invokeAll(tasks);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		executor.shutdown();

		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long elapsedTime = System.nanoTime() - startTime;

		System.out.println("End time :  " + elapsedTime / 1000000 + " sec");
	}

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "Charles", "Amper", 38, "developer", 50000.0));
		employeeList.add(new Employee(2, "Eric", "Amper", 28, "developer", 30000.0));
		employeeList.add(new Employee(3, "Lawrence", "Amper", 21, "developer", 20000.0));
		employeeList.add(new Employee(4, "Nicandro", "Amper", 50, "manager", 60000.0));
		employeeList.add(new Employee(5, "Lorna", "Amper", 50, "manager", 60000.0));
		
		
		// Serial way
		double salaryManager = employeeList.stream().filter(p -> p.getRole().equals("manager")).mapToDouble(p -> p.getSalary()).sum();
		System.out.println("Total salary manager : " + salaryManager);
		
		double salaryDevelopr = employeeList.parallelStream().filter(p -> p.getRole().equals("developer")).mapToDouble(p->p.getSalary()).sum();
		System.out.println("Total developr manager : " + salaryDevelopr);
		
		
	}
}
