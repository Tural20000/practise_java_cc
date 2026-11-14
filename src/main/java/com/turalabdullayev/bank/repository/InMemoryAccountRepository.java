package com.turalabdullayev.bank.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.turalabdullayev.bank.model.Account;

public class InMemoryAccountRepository implements AccountRepository {
	private final Map<Long, Account> storage = new LinkedHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong();

	@Override
	public Account save(Account account) {
		if (account.getId() == null) {
			account.setId(idGenerator.incrementAndGet());

		}
		storage.put(account.getId(), account);
		return account;
	}

	@Override
	public Optional<Account> findById(Long id) {
		return Optional.ofNullable(storage.get(id));

	}

	@Override
	public Optional<Account> findByAccountNumber(String accountNumber) {
		return storage.values().stream().filter(account -> account.getAccountNumber().equals(accountNumber))
				.findFirst();
	}

	@Override
	public List<Account> findByOwnerId(Long customerId) {
		return storage.values().stream().filter(account -> account.getOwner().getId().equals(customerId)).toList();

	}

	@Override
	public List<Account> findAll() {
		return List.copyOf(storage.values());
	}

}
