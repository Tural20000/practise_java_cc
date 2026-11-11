package com.turalabdullayev.bank.repository;

import java.util.List;
import java.util.Optional;

import com.turalabdullayev.bank.model.Customer;

public interface CustomerRepository {
	Customer save(Customer customer);

	Optional<Customer> findById(Long id);

	Optional<Customer> findByEmail(String email);

	List<Customer> findAll();

}
