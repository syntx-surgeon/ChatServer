package com.example.demo.newpackage;


import com.example.demo.newpackage.oop.polymerphism.AccountTransactionService;
import com.example.demo.newpackage.oop.polymerphism.CurrentAccount;
import com.example.demo.newpackage.oop.polymerphism.InterestTransactionService;
import com.example.demo.newpackage.oop.polymerphism.SavingAccount;

/**
 * author: Santosh Kumar Subedi
 * createdDate:2/23/25
 * projectName:demo7
 **/
public class PolyMain {
	public static void main(String[] args){
		AccountTransactionService accountTransactionService = new CurrentAccount("1234",4000.0,10.00);
		accountTransactionService.deposit(1000.0);
		accountTransactionService.withdraw(8000.0);
		System.out.println("Testing text");
	}
}
