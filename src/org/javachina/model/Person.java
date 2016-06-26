package org.javachina.model;

public class Person {
	private String name;
	private Person(){
		System.out.println("无参构造器被调用了");
	}
	public Person(String name){
		this.name = name;
		System.out.println(name);
	}
	public String getName() {
		return name;
	}
	public void say(){
		System.out.println("say method is invoked!");
	}
	public void eat(String type){
		System.out.println("I am eating"+type);
	}
	
	public static void staticMethod(String src){
		System.out.println("静态方法被调用"+src);
	}
}
