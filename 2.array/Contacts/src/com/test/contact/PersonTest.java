package com.test.contact;

public class PersonTest {
	public static void main(String[] args) {
		Person p12 = new Person();
		p12.age = 10;
		p12.name = "Tom";
		p12.isMale = true;
		
		p12.eat();
		p12.sleep();
		p12.talk("hh");
		p12.info();
		
		Person p2 = new Person();
		p2.info();
		
		Person[] per = new Person[5];
		System.out.println(per[0]);
	}
}

class Person{
	String name;
	int age;
	boolean isMale;
	
	public void info() {
		System.out.println("age:"+age);
		System.out.println("name:"+name);
		System.out.println("isMale:"+isMale);
	}
	
	public void eat() {
		System.out.println("eat");
	}
	public void sleep() {
		System.out.println("sleep");
	}
	public void talk(String str) {
		System.out.println("talk:"+str);
	}
}

class Person1{
	int id;
	String name;
	public Person1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}



