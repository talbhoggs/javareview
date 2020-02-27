package com.ibm.ph.amperca;

public class JavareviewApplication {
	
	// primitive
	
	
	int i = 0;
	byte byteType = 0;
	short shortType = 0;
	int integerType = 0;
	long longType = 0;
	
	double dbleType = 0.0;
	
	
	
	// objects
	
	// custom object
	String objects;
	
	
	// predefine
	// Employee
	
	
	public static void main(String[] args) {
		String reverse1 = "Charles";
		System.out.println(" >>> " + reverseString(reverse1));
		
	}
	
	public static String reverseString(String value) {
		
		char[] a = value.toCharArray();
		StringBuffer va = new StringBuffer();
		for(int i1 = a.length-1; i1>=0; i1--) {
			va.append(a[i1]);
		}
		
		return va.toString();
	}
}





