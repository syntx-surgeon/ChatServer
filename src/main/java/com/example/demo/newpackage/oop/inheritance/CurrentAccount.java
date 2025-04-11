package com.example.demo.newpackage.oop.inheritance;

public class CurrentAccount extends Account{

	private long overdraftAmount;

	public CurrentAccount(String accountNumber, long balance,long overdraftAmount) {
		super(accountNumber, balance);
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public void withdraw(long amount) {
		long currentBalance = super.getBalance();
		if(amount>(currentBalance+overdraftAmount)){
			System.out.println("Not Enough Balance.");
			return;
		}
		currentBalance = currentBalance-amount;
		super.setBalance(currentBalance);
	}
}