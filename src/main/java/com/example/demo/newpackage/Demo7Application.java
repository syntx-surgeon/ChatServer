package com.example.demo.newpackage;


import java.util.Scanner;

public class Demo7Application {

	public static void main(String[] args) {

		int i = 0;
		do {
			try {
				System.out.println("Insert A Number");
				Scanner scanner = new Scanner(System.in);
				int temp = scanner.nextInt();
				if(temp>7||temp<0){
					System.out.println("Invalid Input");
				}else {
					i = temp;
				}
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}
		}while(i==0);

		switch (i){
			case 1-> System.out.println("Sunday");
			case 2-> System.out.println("Monday");
			default-> System.out.println("Please Provide Proper Input");
	 }

	}

}
