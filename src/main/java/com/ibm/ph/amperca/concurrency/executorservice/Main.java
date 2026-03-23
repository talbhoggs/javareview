package com.ibm.ph.amperca.concurrency.executorservice;

import java.util.concurrent.*;
public class Main {
        public static void main(String[] args) {
            

        // Using executer service
        // - uses thread pool which you can define how many numbers
        // it can run cucurrently
        // in this example 4 means it can handle 4 thread at a time

        // Executor Service handles Thread management: Instead of manually creating and managing threads, 
        // ExecutorService provides a pool of worker threads. This avoids overhead and makes scaling easier.


        // 0. Initialize 
        // Define the number of threads it can handle or manage
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 1. Tasks (Callable or Runnable)
        var myCall = new MyCallable("callable 1");
        var myCal2= new MyCallable("callable 2");

        try {
            // 2.  Submit tasks and get Futures
            // It represents something that will be available later.
            Future<String> call1 = executor.submit(myCall);
            Future<String> call2 = executor.submit(myCal2);

            // 3. Retrieve results (blocking until ready)
            System.out.println("Call 1: " + call1.get());
            System.out.println("Call 2 : " + call2.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

   } 
}

// Callable usually used in executor sevice
// compare to runnable and thread
// the Callable expected you to return something
class MyCallable implements Callable<String> {

    private String threadName;

    public MyCallable(String threadName) {
        this.threadName = threadName;

    }

    @Override
    public String call() throws Exception {
         for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         return "Success";      
    }

}