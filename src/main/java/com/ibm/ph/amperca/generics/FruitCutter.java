package com.ibm.ph.amperca.generics;

public class FruitCutter<T> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return (T) this.t;
	}
}
