package com.xx.singleton;

public class SingletonTest2 {
	public static void main(String[] args) {
		Earth e1 = Earth.getInstance();
		Earth e2 = Earth.getInstance();
		System.out.println(e1 == e2);
	}
}
/*
 * 懒汉式
 */
class Earth{
	private Earth() {
		
	}
	private static Earth instance = null;
	//方式一:
	public static Earth getInstance() {
		if(instance ==null) {
			synchronized (Earth.class) {
				if(instance == null) {
					instance = new Earth();
				}
			}	
		}
		return instance;
	}
	//方式二:
//	public static synchronized Earth getInstance() {
//		if(instance == null) {
//			instance = new Earth();
//		}
//		return instance;
//	}
}
