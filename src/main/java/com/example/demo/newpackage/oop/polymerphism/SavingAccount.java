package com.example.demo.newpackage.oop.polymerphism;

import com.example.demo.newpackage.cframework.TransactionHistory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SavingAccount implements AccountTransactionService, InterestTransactionService, Serializable {

	private String accountNumber;
	private Double balance;
	private Double interestRate;
	private List<TransactionHistory> transactionHistories;

	public SavingAccount(String accountNumber, Double balance, Double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		transactionHistories = new ArrayList<>();
	}

	@Override
	public void deposit(Double amount) {
		balance = this.balance + amount;
	}

	@Override
	public void withdraw(Double amount) {
		if (balance >= amount) {
			balance = balance - amount;
		} else {
			System.out.println("You don't have sufficient balance.");
		}
	}

	@Override
	public void deposit(Double amount, String sourceOfFund) {
		this.deposit(amount);
		//Handle source of fund as required.
		System.out.printf("Customer got the money from %s%n", sourceOfFund);
	}

	@Override
	public void displayHistory() {
		System.out.println("AMOUNT               TYPE                Message");
		for (int i = 0; i < transactionHistories.size(); i++) {

			TransactionHistory history = transactionHistories.get(i);
			System.out.printf("%s               %s                %s%n", history.getAmount(), history.isDeposit() ? "Deposite" : "Credit", history.getOperationMessage());
		}
	}

	@Override
	public Double calculateInterest() {
		double time = 1 / 12;
		double interest = time * interestRate * balance;
		return interest;
	}

	@Override
	public void processInterest(SavingAccount account) {
		double interest = this.calculateInterest();
		account.deposit(interest);
	}

	@Override
	public void processInterest() {
		double interest = this.calculateInterest();
		this.deposit(interest);
	}


	public void displayBalance() {
		System.out.printf("Your Available Balance is : Rs. %s%n", balance);
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public boolean writeTransactionHistory(TransactionHistory transactionHistory) {
		transactionHistories.add(transactionHistory);
		return true;
	}
}