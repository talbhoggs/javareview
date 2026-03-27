package com.ibm.ph.amperca.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    
    public static void main(String[] args) {
       // IMPORTANT
       // FUNCTIONAL INTERFACE LET YOU express a lambda expression 

       // 1.) Creating own lambda
       //
       // Not using lambda (Regular method)
       var notUsingLambdaEx = new NotUsingLambda();
       notUsingLambdaEx.overideThisMethod();

        // Using lambda
        MyFunctionalInterface myFunc = () -> {
            System.out.println("Using lambda");
        };
        myFunc.overideThisMethod();

        MyFunctionalInterfaceInput myInput = (a,b) -> System.out.println(a + " + " + b + " = " + (a+b)); 
        myInput.methodInputParams(2,3);


        int[] numbers = {1,2,4,3,6,10};
        Predicate<Integer> isEven = (a)->a%2==0;

        System.out.println("Event numbers");
        processNumbers(numbers, isEven);
        System.out.println("Odd numbers");
        processNumbers(numbers, isEven.negate());

        Predicate<Integer> isOdd = (a)->a%2!=0;
        System.out.println("Odd numbers -- Manual");
        processNumbers(numbers, isOdd);
        
        
        // Funciton<Input, Output>
        Function<String, String> welcomeMessage = (a)->"Weloome "+a;
        System.out.println(welcomeMessage.apply("Charles"));


        // Method and Constructor Reference :: (Double colon)
        //
        // Static Method reference
        Runnable e = Main::RunnableStaticMethod;
        Thread t = new Thread(e);
        t.start();

        // Instance Method reference
        InstanceDoubleColonRef idC = new InstanceDoubleColonRef();
        InstanceDoubleColonRefInterface idInteface = idC::helloMethod;
        idInteface.helloMethodInstance("Charles"); 

        // Constructor Referencing
        ConstructorRefInterfae cRIn = ConstructorRefClass::new;
        cRIn.helloMethodConstructor("Hello Constructor Ref"); 
    }

    static void RunnableStaticMethod(){
        for(int i=0; i<10; i++) {
            System.out.println(">> " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void processNumbers(int[] nums, Predicate<Integer> pre) {
        for (int i : nums) {
            if(pre.test(i)){
                System.out.println(i);
            }
        }
    }
}

/*
    Functional Interface 
    1. must have only 1 method
    2. @FunctionalInterface is marker for jvm
    that let you know that this is a functional interface 
*/

@FunctionalInterface
interface MyFunctionalInterface {

    // one abstract method
    void overideThisMethod();

    default void defaultMethod() {
        System.out.println("Default Method1");
    }
    
    default void defaultMethod1() {
        System.out.println("Default Method2");
    }
}

// implemententing Functional Interface 
// Not using Lambda(Regular method)
class NotUsingLambda implements MyFunctionalInterface {

    @Override
    public void overideThisMethod() {
        System.out.println("Not using Lambda");
    }
    
}

// Example that has 2 inputs
@FunctionalInterface
interface MyFunctionalInterfaceInput {

    void methodInputParams(int a, int b);

}

// if you extend the functional interface 
// and add new abstract method
// this will not be a functional interface anymore
@FunctionalInterface
interface NotAFunctionalInterface extends MyFunctionalInterface{

    // new abstract method
    void myMethod();
}

// Instance Method Ref
@FunctionalInterface
interface InstanceDoubleColonRefInterface {

    void helloMethodInstance(String msg);
    
}

class InstanceDoubleColonRef {
    public void helloMethod(String msg) {
        System.out.println("Hello " + msg);
    }
}

// Constructor Ref
@FunctionalInterface
interface ConstructorRefInterfae {
    void helloMethodConstructor(String msg);
}

class ConstructorRefClass {
    private String msg;
    public ConstructorRefClass(String msg) {
        this.msg = msg;
        System.out.println("Inside constructor reference : " + msg);
    }
}