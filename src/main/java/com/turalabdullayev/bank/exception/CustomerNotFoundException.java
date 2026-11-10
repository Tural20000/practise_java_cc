package com.turalabdullayev.bank.exception;

public class CustomerNotFoundException extends BankException {
	public CustomerNotFoundException(Long customerId) {
		super("Customer not found with idL " + customerId);
	}

}
