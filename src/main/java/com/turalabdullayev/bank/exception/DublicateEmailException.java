package com.turalabdullayev.bank.exception;

public class DublicateEmailException extends BankException {
	public DublicateEmailException(String email) {
		super("Customer with email already exists:" + email);
	}

}
