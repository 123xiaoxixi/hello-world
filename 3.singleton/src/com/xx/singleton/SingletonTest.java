package com.xx.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		Bank b1 = Bank.getInstance();
		Bank b2 = Bank.getInstance();
		System.out.println(b1 == b2);
	}
}

/*
 * 单例设计模式:饿汉式
 */
class Bank{
	private Bank() {
		
	}
	private static Bank bank = new Bank();
	public static Bank getInstance() {
		return bank;
	}
}
