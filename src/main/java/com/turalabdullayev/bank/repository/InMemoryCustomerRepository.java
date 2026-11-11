package com.turalabdullayev.bank.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.turalabdullayev.bank.model.Customer;

public class InMemoryCustomerRepository implements CustomerRepository {
	private final Map<Long, Customer> storage = new LinkedHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(0);

	@Override
	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			customer.setId(idGenerator.incrementAndGet());

		}
		storage.put(customer.getId(), customer);
		return customer;
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
		return storage.values().stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email)).findFirst();
	}

	@Override
	public List<Customer> findAll() {
		return List.copyOf(storage.values());

	}

}
