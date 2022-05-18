package com.test.contact;

import java.util.Arrays;

//import java.util.Arrays;

public class MethodArgsTest {
	public static void main(String[] args) {
		MethodArgsTest test = new MethodArgsTest();
		int[] d = {1,2,3};
		test.show("hello","world");
		test.show(d);
	}
	
	public void show(int[] i) {
		String s = Arrays.toString(i);
		
		System.out.println(s);
		
		
		int dd = 1;
		
	}
	public void show(String s) {
		
	}
	public void show(String ... strs) {
		
	}
}
