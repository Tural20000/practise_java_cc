package com.turalabdullayev.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.turalabdullayev.bank.enums.AccountStatus;
import com.turalabdullayev.bank.enums.AccountType;

public class Account {
	private Long id;
	private final String accountNumber;
	private final Customer owner;
	private BigDecimal balance;
	private final AccountType type;
	private AccountStatus status;
	private final LocalDateTime createdAt;

	public Account(String accountNumber, Customer owner, AccountType type) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.type = type;
		this.balance = BigDecimal.ZERO;
		this.status = AccountStatus.ACTIVE;
		this.createdAt = LocalDateTime.now();

	}

	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Customer getOwner() {
		return owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
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
		Account other = (Account) o;
		return Objects.equals(accountNumber, other.accountNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}

	@Override
	public String toString() {
		return "Account{id=" + id + ", accountNumber='" + accountNumber + "', owner=" + owner.getFullName()
				+ ", balance=" + balance + ", type=" + type + ", status=" + status + "}";
	}

}
