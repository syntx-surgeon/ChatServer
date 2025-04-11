package com.example.demo.newpackage.oop.polymerphism;

public interface AccountTransactionService {

	void deposit(Double amount);

	void withdraw(Double amount);

	void deposit(Double amount,String sourceOfFund);

	void displayHistory();
}