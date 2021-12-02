package com.fabs.bank.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fabs.bank.enums.TransactionTypes;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

	@NotNull
	@Id
	private String requestId;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionTime;

	@NotNull
	private String requester;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TransactionTypes transactionType;

	@NotNull
	@ManyToOne
	private Account sourceAccountNumber;

	@NotNull
	private double amount;

	@NotNull
	@ManyToOne
	private Account destinationAccountNumber;
	
	@NotNull
	private String note;
	
	public Transaction() {}

	public Transaction(@NotNull String requestId, @NotNull String requester, @NotNull TransactionTypes transactionType,
			@NotNull Account sourceAccountNumber, @NotNull double amount, @NotNull Account destinationAccountNumber,
			@NotNull String note) {
		super();
		this.requestId = requestId;
		this.requester = requester;
		this.transactionType = transactionType;
		this.sourceAccountNumber = sourceAccountNumber;
		this.amount = amount;
		this.destinationAccountNumber = destinationAccountNumber;
		this.note = note;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public TransactionTypes getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypes transactionType) {
		this.transactionType = transactionType;
	}

	public Account getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(Account sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(Account destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
