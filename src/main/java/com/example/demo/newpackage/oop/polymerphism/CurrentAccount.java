package com.example.demo.newpackage.oop.polymerphism;

public class CurrentAccount implements AccountTransactionService{
	private  String accountNumber;
	private Double balance;
	private Double overdraftAmount;

	public CurrentAccount(String accountNumber,Double balance,Double overdraftAmount){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public void deposit(Double amount) {
		this.balance = this.balance + amount;
	}

	@Override
	public void withdraw(Double amount) {
		if((balance+overdraftAmount)>=amount){
			this.balance=this.balance-amount;
		}else{
			System.out.println("You don't have sufficient balance.");
		}
	}

	@Override
	public void deposit(Double amount, String sourceOfFund) {

	}

	@Override
	public void displayHistory() {

	}
}