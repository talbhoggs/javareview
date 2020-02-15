package com.ibm.ph.amperca.enumeration;

public class Main {
	public static void main(String[] args) {
		Computer mac = new Computer();
		
		mac.setState(PowerState.ON);
		
		
		System.out.println("MAC computer is in " + mac.getState().getDescription());
		System.out.println("CURRENT state is " + mac.getState());
	}

}
