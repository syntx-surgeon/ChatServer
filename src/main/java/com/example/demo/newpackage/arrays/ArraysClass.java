package com.example.demo.newpackage.arrays;

/**
 * author: Santosh Kumar Subedi
 * createdDate:2/18/25
 * projectName:demo7
 **/
import java.util.Scanner;

public class ArraysClass {
	public static void main(String[] args){

//		int numberArray[] = {1,2,3,4,5,6};
//
//		for (int i = 0; i < numberArray.length; i++) {
//			System.out.println(numberArray[i]);
//		}
//
//		String[] stringArray = {"AAA","BBB","CCC"};
//		StringBuilder stringBuilder = new StringBuilder();
//		for (int i = 0; i < stringArray.length; i++) {
//			stringBuilder.append(stringArray[i]).append(" ");
//		}
//
//		System.out.println(stringBuilder);
//
//		String[] string = new String[10];
//		string[0] = "first";
//
//		System.out.println("---------------------");
//		String []name ={"suman","hari","ram","shyam"};
//		for(String value : name){
//			System.out.println(value);
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.print("Enter a value: ");
		try {
			a = sc.nextInt();
			System.out.println(a);
		}catch (Exception ex ){
			System.out.println("Invalid input type");
		}


		}
	}

