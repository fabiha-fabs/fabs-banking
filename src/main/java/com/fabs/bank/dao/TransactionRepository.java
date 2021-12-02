package com.fabs.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.fabs.bank.models.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String>{}
