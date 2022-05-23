package com.xx.singleton;

public class SingletonTest2 {
	public static void main(String[] args) {
		Earth e1 = Earth.getInstance();
		Earth e2 = Earth.getInstance();
		System.out.println(e1 == e2);
	}
}
/*
 * 单例模式:懒汉式
 */
class Earth{
	private Earth() {
		
	}
	private static Earth instance = null;
	public static Earth getInstance() {
		if(instance == null) {
			instance = new Earth();
		}
		return instance;
	}
}
