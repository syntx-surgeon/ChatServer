package com.example.demo.newpackage.oop.inheritance;

public class SavingAccount extends Account{

	private long interestRate;
	private long minBalance;

	public SavingAccount(String accountNumber, long balance,long interestRate,long minBalance) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
		this.minBalance = minBalance;
	}

	public void calculateInterest(){
		long principle = super.getBalance();
		float time = 1/12;
		long interest = principle*interestRate;
		System.out.printf("Calculated Interest : %s%n",interest);
		super.deposite(interest);
	}

	@Override
	public void withdraw(long amount) {
		if((super.getBalance()-minBalance)<amount){
			super.withdraw(amount);
		}else{
			System.out.println("Not Enough Balance.");
		}

	}
}