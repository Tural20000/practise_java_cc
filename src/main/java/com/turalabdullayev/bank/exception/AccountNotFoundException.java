package com.turalabdullayev.bank.exception;

public class AccountNotFoundException extends BankException {
	public AccountNotFoundException(String identifier) {
		super("Account not found: " + identifier);
	}

}
