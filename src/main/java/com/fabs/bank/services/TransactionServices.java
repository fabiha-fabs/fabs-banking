package com.fabs.bank.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fabs.bank.dao.AccountRepository;
import com.fabs.bank.dao.TransactionRepository;
import com.fabs.bank.dto.DecryptedTransactionResponse;
import com.fabs.bank.dto.EncryptedTransactionRequest;
import com.fabs.bank.enums.TransactionTypes;
import com.fabs.bank.models.Account;
import com.fabs.bank.models.Transaction;

@Service
public class TransactionServices {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private TransactionRepository transactionRepo;

	public void makeTransaction(EncryptedTransactionRequest transactionRequest) throws Exception {
		DecryptedTransactionResponse decryptedTransactionRequest = restTemplate.postForObject(
				"http://localhost:8282/base64/decode", transactionRequest, DecryptedTransactionResponse.class);
		this.conductValidTransaction(decryptedTransactionRequest,
				this.validateTransaction(decryptedTransactionRequest));
	}

	private void conductValidTransaction(DecryptedTransactionResponse transactionRequest, List<Account> accounts) {
		Account source = accounts.get(0);
		Account destination = accounts.get(1);
		double amount = Double.parseDouble(transactionRequest.getAmount());
		if (transactionRequest.getTransactionType().equalsIgnoreCase(TransactionTypes.TRANSFER.name())) {
			source.setBalance(source.getBalance() - amount);
			destination.setBalance(destination.getBalance() + amount);
		} else if (transactionRequest.getTransactionType().equalsIgnoreCase(TransactionTypes.REVERSE.name())) {
			source.setBalance(source.getBalance() + amount);
			destination.setBalance(destination.getBalance() - amount);
		}
		accountRepo.saveAll(Arrays.asList(source, destination));
		this.createTransactionHistory(amount, transactionRequest, source, destination);
	}

	private void createTransactionHistory(double amount, DecryptedTransactionResponse transactionRequest,
			Account sourceAcc, Account destinationAcc) {
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDestinationAccountNumber(destinationAcc);
		transaction.setNote(transactionRequest.getNote());
		transaction.setRequester(transactionRequest.getRequester());
		transaction.setRequestId(transactionRequest.getRequestId());
		transaction.setSourceAccountNumber(sourceAcc);
		transaction.setTransactionType(
				TransactionTypes.TRANSFER.name().equalsIgnoreCase(transactionRequest.getTransactionType())
						? TransactionTypes.TRANSFER
						: TransactionTypes.REVERSE);
		transactionRepo.save(transaction);
	}

	private List<Account> validateTransaction(DecryptedTransactionResponse decrypted) throws Exception {
		Account sourceAcc = this.getAccount(decrypted.getSourceAccountNumber());
		if (sourceAcc == null) {
			throw new Exception("Souce Account is not valid");
		}
		Account destinationAcc = this.getAccount(decrypted.getDestinationAccountNumber());
		if (destinationAcc == null) {
			throw new Exception("Destination Account is not valid");
		}
		double transactionAmount = this.getTransactionAmount(decrypted.getAmount());
		this.validateBalance(transactionAmount, decrypted, sourceAcc, destinationAcc);

		return Arrays.asList(sourceAcc, destinationAcc);
	}

	private void validateBalance(double transactionAmount, DecryptedTransactionResponse decrypted, Account sourceAcc,
			Account destinationAcc) throws Exception {
		if (decrypted.getTransactionType().equalsIgnoreCase(TransactionTypes.TRANSFER.name())
				&& transactionAmount > sourceAcc.getBalance()) {
			throw new Exception("Transfer amount is bigger than available balance");
		} else if (decrypted.getTransactionType().equalsIgnoreCase(TransactionTypes.REVERSE.name())
				&& transactionAmount > destinationAcc.getBalance()) {
			throw new Exception("Reverse transfer amount is bigger than available balance in destination");
		}
	}

	private double getTransactionAmount(String amount) throws Exception {
		try {
			return Double.parseDouble(amount);
		} catch (Exception e) {
			throw new Exception("Transaction amount is not valid.");
		}
	}

	private Account getAccount(String accNo) {
		return accountRepo.findById(accNo).get();
	}
}
