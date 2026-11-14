package com.turalabdullayev.bank.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.turalabdullayev.bank.model.Transaction;

public class InMemoryTransactionRepository implements TransactionRepository {
	private final List<Transaction> storage = new ArrayList<>();
	private final AtomicLong idGenerator = new AtomicLong(0);

	@Override
	public Long nextId() {
		return idGenerator.incrementAndGet();

	}

	@Override
	public Transaction save(Transaction transaction) {
		storage.add(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> findByAccountNumber(String accountNumber) {
		return storage.stream().filter(t -> involves(t, accountNumber))
				.sorted(Comparator.comparing(Transaction::getTimestamp).reversed()).toList();
	}

	@Override
	public List<Transaction> findAll() {
		return List.copyOf(storage);
	}

	private boolean involves(Transaction transaction, String accountNumber) {
		boolean isSender = transaction.getFromAccount() != null
				&& transaction.getFromAccount().getAccountNumber().equals(accountNumber);
		boolean isReceiver = transaction.getToAccount() != null
				&& transaction.getToAccount().getAccountNumber().equals(accountNumber);
		return isSender || isReceiver;
	}

}
