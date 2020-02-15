package com.ibm.ph.amperca.generics;

public class Apple {
	private String name;

	@Override
	public String toString() {
		return "Apple [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
