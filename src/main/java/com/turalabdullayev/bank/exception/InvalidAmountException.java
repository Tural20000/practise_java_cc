package com.turalabdullayev.bank.exception;

import java.math.BigDecimal;

public class InvalidAmountException extends BankException {
	public InvalidAmountException(BigDecimal amount) {
		super("Invalid amount: " + amount + ". Amount must be greater than zero");
	}

}
