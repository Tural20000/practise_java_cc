package com.turalabdullayev.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.turalabdullayev.bank.enums.TransactionType;

public class Transaction {
	private final Long id;
	private final TransactionType type;
	private final BigDecimal amount;
	private final Account fromAccount;
	private final Account toAccount;
	private final LocalDateTime timestamp;
	private final String description;

	public Transaction(Long id, TransactionType type, BigDecimal amount, Account fromAccount, Account toAccount,
			String description) {
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.description = description;
		this.timestamp = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public TransactionType getType() {
		return type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Transaction other = (Transaction) o;
		return Objects.equals(id, other.id);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Transaction{id=" + id + ", type=" + type + ", amount=" + amount + ", from="
				+ accountNumberOf(fromAccount) + ", to=" + accountNumberOf(toAccount) + ", timestamp=" + timestamp
				+ ", description='" + description + "'}";
	}

	private static String accountNumberOf(Account account) {
		return account == null ? "-" : account.getAccountNumber();
	}

}
