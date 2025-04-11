package com.example.demo.newpackage;

public class NewClass{
	public int b = 2;
	public static final int c = 3;
	public String name = "fghjk";
	public Integer newInteger = 0;

	public NewClass(int b){
		this.b=b;
	}

	public NewClass(){

	}

	public void function1(){
		int a =1;
		System.out.println(String.format("Value of a %s",a));
		System.out.println(String.format("Value of b %s",b));
		b=7;
		this.function2();
	}

	public void function1(int b){
		this.b = b;
	}

	public void function2(){
		System.out.println(String.format("Value of b %s",b));
	}

	public void function3(){
		MemberClass memberClass = new MemberClass();
		int b = memberClass.a;

	}
}