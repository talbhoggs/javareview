package com.ibm.ph.amperca.generics;

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
	}
}
