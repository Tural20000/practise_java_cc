package com.turalabdullayev.bank.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Customer {
	private Long id;
	private final String fullName;
	private final String email;
	private final String phone;
	private final LocalDateTime createdAt;

	public Customer(String fullName, String email, String phone) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.createdAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;

	}

	public String getPhone() {
		return phone;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Customer other = (Customer) o;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);

	}

	@Override
	public String toString() {
		return "Customer{id=" + id + ", fullName='" + fullName + "', email='" + email + "', phone'" + phone + "'}";
	}

}
