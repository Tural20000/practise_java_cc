package com.turalabdullayev.bank.exception;

import com.turalabdullayev.bank.enums.AccountStatus;

public class AccountNotActiveException extends BankException {
	public AccountNotActiveException(String accountNumber, AccountStatus status) {
		super("Acoount " + accountNumber + " is not active. Current status: " + status);
	}

}
