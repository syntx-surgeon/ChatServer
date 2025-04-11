package com.example.demo.newpackage.cframework;

import java.io.Serializable;

public class TransactionHistory implements Serializable {
	private boolean isDeposit;
	private Double amount;
	private String operationMessage;

	public TransactionHistory(boolean isDeposit,Double amount,String operationMessage){
		this.isDeposit = isDeposit;
		this.amount = amount;
		this.operationMessage = operationMessage;
	}

	public boolean isDeposit() {
		return isDeposit;
	}

	public void setDeposit(boolean deposit) {
		isDeposit = deposit;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOperationMessage() {
		return operationMessage;
	}

	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}
}