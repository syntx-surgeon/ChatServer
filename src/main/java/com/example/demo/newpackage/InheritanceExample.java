package com.example.demo.newpackage;

import com.example.demo.newpackage.oop.inheritance.Account;
import com.example.demo.newpackage.oop.inheritance.CurrentAccount;
import com.example.demo.newpackage.oop.inheritance.SavingAccount;

/**
 * author: Santosh Kumar Subedi
 * createdDate:2/23/25
 * projectName:demo7
 **/
public class InheritanceExample {
	public static void main(String[] args){
		Account currentAccount = new CurrentAccount("00098765432",5000,5000);
		currentAccount.checkBalance();
		currentAccount.withdraw(1000);
		currentAccount.deposite(5000);
		currentAccount.withdraw(10000);
		currentAccount.withdraw(5000);

		SavingAccount savingAccount = new SavingAccount("7884565232", 10000L,20,1000);
		savingAccount.checkBalance();
		savingAccount.calculateInterest();
		savingAccount.deposite(1000);
		savingAccount.withdraw(10000);
		savingAccount.withdraw(10000);

	}
}
