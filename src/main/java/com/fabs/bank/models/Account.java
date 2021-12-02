package com.fabs.bank.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fabs.bank.enums.AccountStatus;

@Entity
public class Account {
	@Id
	private String id;
	
	@NotNull
	private String name;

	@NotNull
	private String address;
	
	@NotNull
	private String accountNumber;
	
	@NotNull
	private double balance;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	
	public Account() {}

	public Account(@NotNull String name, @NotNull String address, @NotNull String accountNumber,
			@NotNull double balance) {
		this.name = name;
		this.address = address;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
}
