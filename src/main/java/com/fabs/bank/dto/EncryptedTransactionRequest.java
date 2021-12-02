package com.fabs.bank.dto;

import javax.validation.constraints.NotNull;

public class EncryptedTransactionRequest {
	@NotNull
	private String requestId;
	
	@NotNull
	private String requester;

	@NotNull
	private String transactionType;

	@NotNull
	private String sourceAccountNumber;

	@NotNull
	private String amount;

	@NotNull
	private String destinationAccountNumber;
	
	@NotNull
	private String note;

	public EncryptedTransactionRequest(@NotNull String requestId, @NotNull String requester, @NotNull String transactionType,
			@NotNull String sourceAccountNumber, @NotNull String amount, @NotNull String destinationAccountNumber,
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

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(String destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
