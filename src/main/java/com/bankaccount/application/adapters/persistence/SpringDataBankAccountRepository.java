package com.bankaccount.application.adapters.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bankaccount.application.domain.BankAccount;


/**
 * Mongo specific Repository interface to manage Bank Account
 * 
 * @author c.cordier
 *
 */
public interface SpringDataBankAccountRepository extends MongoRepository<BankAccount, Long> {}
