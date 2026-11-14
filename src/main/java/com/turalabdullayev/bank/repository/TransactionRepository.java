package com.turalabdullayev.bank.repository;

import java.util.List;

import com.turalabdullayev.bank.model.Transaction;

public interface TransactionRepository {
	Long nextId();

	Transaction save(Transaction transaction);

	List<Transaction> findByAccountNumber(String accountNumber);

	List<Transaction> findAll();

}
