package com.example.demo.newpackage.cframework;

import com.example.demo.newpackage.oop.polymerphism.SavingAccount;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankHandler {
	// NOTES: https://notes.io/wZYqq
	private final Map<String, SavingAccount> accounts;

	public BankHandler() {
		accounts = new HashMap<>();
		loadAccountInformation();
	}

	public void loadAccountInformation() {
		File file = new File("bankinfo.txt");
		if(!file.exists()) {
			SavingAccount savingAccount1 = new SavingAccount("12345", 5000.0, 10.0);
			SavingAccount savingAccount2 = new SavingAccount("123456", 5000.0, 10.0);
			SavingAccount savingAccount3 = new SavingAccount("1234567", 5000.0, 10.0);
			SavingAccount savingAccount4 = new SavingAccount("12345678", 5000.0, 10.0);
			accounts.put(savingAccount1.getAccountNumber(), savingAccount1);
			accounts.put(savingAccount2.getAccountNumber(), savingAccount2);
			accounts.put(savingAccount3.getAccountNumber(), savingAccount3);
			accounts.put(savingAccount4.getAccountNumber(), savingAccount4);
		}else{
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				Map<String,SavingAccount> tempAccounts = (Map<String, SavingAccount>) objectInputStream.readObject();
				accounts.putAll(tempAccounts);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public void start() {
		System.out.println("!!! Welcome To Bank Of Nepal !!!");
		System.out.println("Enter Your Account Number");
		String accountNumber = validateAccountNumber();
		while (true){
			try {
				File file = new File("bankinfo.txt");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(accounts);
				objectOutputStream.close();
				fileOutputStream.close();
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			Integer operation = validateOperations();
			boolean operationExecution = this.handleOperation(operation, accountNumber);
			//TODO Ask User if they want to continue
		}

	}

	public String validateAccountNumber() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String accountNumber = scanner.nextLine();
			if (!accounts.containsKey(accountNumber)) {
				System.out.println("Invalid Account Number");
				continue;
			}
			return accountNumber;
		}
	}

	public Integer validateOperations() {
		System.out.println("Insert Operation");
		System.out.println("1.Read Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Credit");
		System.out.println("4.Calculate Interest");
		System.out.println("5.Credit Transfer");
		System.out.println("6.Read History");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				int operation = scanner.nextInt();
				if (operation > 0 && operation < 7) {
					return operation;
				} else {
					System.out.println("Invalid Operation Try Again");
				}
			} catch (Exception e) {
				System.out.println("Invalid Operation Try Again");
			}
		}
	}

	public boolean handleOperation(Integer operationCode, String accountNumber) {
		SavingAccount account = accounts.get(accountNumber);
		switch (operationCode) {
			case 1: {
				readBalance(account);
				// Read Balance Operation
				break;
			}
			case 2: {
				// Deposit
				handleDeposit(account);
				break;
			}
			case 3: {
				handleWithdraw(account);
				break;
			}
			case 4: {
				handleInterestCalculation(account);
				// Interest
				break;
			}
			case 5: {
				handleFundTransfer(account);
				// Transfer
				break;
			}
			case 6: {
				handleAccountHistory(account);
			}
			default: {
				System.out.println("Invalid Operation");
				return false;
			}
		}
		return true;
	}

	private void handleAccountHistory(SavingAccount account) {
		account.displayHistory();
	}

	public void readBalance(SavingAccount account) {
		account.displayBalance();
	}

	public boolean handleDeposit(SavingAccount account) {
		System.out.println("Please enter amount to deposit.");
		Double amount = validateAmount();
		account.deposit(amount);
		System.out.printf("Amount Rs. %s is deposited into your account.%n", amount);
		account.displayBalance();
		TransactionHistory transactionHistory = new TransactionHistory(true,amount, "Self Deposit to Account");
		account.writeTransactionHistory(transactionHistory);
		return true;
	}

	public boolean handleWithdraw(SavingAccount account) {
		System.out.println("Please enter amount to Withdraw.");
		Double amount = validateAmount();
		account.withdraw(amount);
		System.out.printf("Amount Rs. %s is withdrawn into your account.%n", amount);
		account.displayBalance();
		TransactionHistory transactionHistory = new TransactionHistory(false,amount,"Self Withdraw from account.");
		account.writeTransactionHistory(transactionHistory);
		return true;
	}

	public void handleFundTransfer(SavingAccount account) {
		System.out.println("Please Enter Amount to be transfered.");
		Double amount = validateAmount();
		System.out.println("Please Provide Receiver Account Number.");
		String receiverNumber = validateAccountNumber();
		SavingAccount receiverAccount = accounts.get(receiverNumber);
		account.withdraw(amount);
		receiverAccount.deposit(amount);
		TransactionHistory withdrawHistory = new TransactionHistory(false,amount,String.format("Amount Transferred to account %s",receiverNumber));
		TransactionHistory depositHistory = new TransactionHistory(false,amount,String.format("Amount Transferred from account %s",account.getAccountNumber()));
		account.writeTransactionHistory(withdrawHistory);
		receiverAccount.writeTransactionHistory(depositHistory);
	}

	public void handleInterestCalculation(SavingAccount account){
		System.out.println("Please Provide Nominee Account Number");
		String nomineeAccountNumber = validateAccountNumber();
		SavingAccount nomineeAccount = accounts.get(nomineeAccountNumber);
		account.processInterest(nomineeAccount);
	}

	public Double validateAmount() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				Double amount = scanner.nextDouble();
				return amount;
			} catch (Exception e) {
				System.out.println("Invalid Amount Try Again");
			}
		}
	}

}