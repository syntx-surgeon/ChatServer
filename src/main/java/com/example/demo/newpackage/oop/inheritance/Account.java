package com.example.demo.newpackage.oop.inheritance;

public class Account{
	private String accountNumber;
	private long balance;

	public Account(String accountNumber,long balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void checkBalance(){
		System.out.printf("New Balance: %s%n",balance);
	}

	public void deposite(long amount){
		balance = balance+amount;
		this.checkBalance();
	}

	public void withdraw(long amount){
		if(balance<amount){
			System.out.println("Not Enough Balance.");
			return;
		}
		balance = balance-amount;
		this.checkBalance();
	}

	public long getBalance(){
		return balance;
	}

	protected void setBalance(long balance){
		this.balance = balance;
		checkBalance();
	}

}