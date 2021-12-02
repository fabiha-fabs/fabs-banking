package com.fabs.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.fabs.bank.models.Account;


public interface AccountRepository extends CrudRepository<Account, String> {}
