package com.ibm.ph.amperca.concurrency;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	
	private String name;
	
	public Task(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String call() throws Exception {
		long startTime = System.nanoTime();
		 
		//System.out.println(this.name + " start");
		Thread.sleep(5000);
		System.out.println(this.name + " end");
		long elapsedTime = System.nanoTime() - startTime;
		
		//System.out.println(this.name + " "
        //        + elapsedTime/1000000);

		 
		return null;
	}

}
