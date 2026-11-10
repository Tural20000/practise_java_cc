package com.turalabdullayev.bank.exception;

import java.math.BigDecimal;

public class InsufficientFundsException extends BankException {
	public InsufficientFundsException(String accountNumber, BigDecimal balance, BigDecimal requested) {
		super(String.format("Insufficient funds in account %s: balance=%s, requested=%s", accountNumber, balance,
				requested));
	}

}
