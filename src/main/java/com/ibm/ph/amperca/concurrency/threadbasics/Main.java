package com.ibm.ph.amperca.concurrency.threadbasics;
import java.util.concurrent.*;

public class Main {
   public static void main(String[] args) {
       
       // Ways of creating a thread
       // 1. Extending thread class
       var myThread = new Mythread("Thread-0");
       var myThread1= new Mythread("Thread-1");
       myThread.start();
       myThread1.start();

       // 2. Implementing Runnable interface
        var myRunnable = new MyRunnable("Runnable-0");
        var myRunnable1 = new MyRunnable("Runnable-1");
        
        Thread myT = new Thread(myRunnable);
        Thread myT1 = new Thread(myRunnable1);
        myT.start();
        myT1.start();

       
        // Using executer service
        // - uses thread pool which you can define how many numbers
        // it can run cucurrently
        // in this example 4 means it can 4 thread at a time

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


// 1st way to create a thread
// 
class Mythread extends Thread {
    private String threadName;
    
    public Mythread(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return this.threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }      
    }
}
// 2nd way to create a thread
class MyRunnable implements Runnable {

    private String threadName;
    
    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return this.threadName;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
