package com.example.demo.newpackage.oop.inheritance;

public class StudentAccount extends SavingAccount{

	public StudentAccount(String accountNumber, long balance, long interestRate, long minBalance) {
		super(accountNumber, balance, interestRate, minBalance);
	}

}