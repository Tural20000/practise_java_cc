package com.turalabdullayev.bank.repository;

import java.util.List;
import java.util.Optional;

import com.turalabdullayev.bank.model.Account;

public interface AccountRepository {
	Account save(Account account);

	Optional<Account> findById(Long id);

	Optional<Account> findByAccountNumber(String accountNumber);

	List<Account> findByOwnerId(Long customerId);

	List<Account> findAll();
}
