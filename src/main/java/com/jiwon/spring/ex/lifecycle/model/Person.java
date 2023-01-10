package com.jiwon.spring.ex.lifecycle.model;

public class Person {

	// 이름, 나이
	private String name;
	private int age;
	
	
	// 정보만 관리하는 클래스는 생성자 없이 getter setter만 만든다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
