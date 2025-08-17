package com.ibm.ph.amperca.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		Apple apple = new Apple();
		apple.setName("apple");
		Mango mango = new Mango();
		mango.setName("mango");
		FruitCutter<Apple> cA = new FruitCutter<>();
		FruitCutter<Mango> cM = new FruitCutter<>();
		cA.set(apple);
		cM.set(mango);
		
		System.out.println(cA.get().toString());
		System.out.println(cM.get().toString());


		// UpperBound

		List<Integer> integers = new ArrayList<>();
		integers.add(Integer.valueOf(1));

		upperBoud(integers);

		List<Double> doubles = new ArrayList<>();
		doubles.add(Double.valueOf(1.2));

		upperBoud(doubles);

		List<Number> numberSubClass= new ArrayList<>();
		numberSubClass.add(new NumberSubClass());

		//
		upperBoud(numberSubClass);

		List<String> strings = new ArrayList<>();
		// upperBound (strings); // This will not accept because List<String> is a List of strings.

		// Lower bound

		// accept type
		lowerBound(integers);


		// accepts super class of type
		lowerBound(numberSubClass);

	}

	// this will accept list that has object extend a Number
	// Accepts a type or any of its subclasses.
	// example Integer, Double,  Number
	public static void upperBoud(List<? extends Number> type) {

	}

	// Accepts a type or any of its superclasses.
	// Integer, Number, Object
	public static void lowerBound(List<? super Integer> type) {

	}
}


class NumberSubClass extends Number {

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'intValue'");
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'longValue'");
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'floatValue'");
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'doubleValue'");
	}

}
