package com.bankaccount.application.port.outgoing;

import java.util.Optional;

import com.bankaccount.application.domain.BankAccount;


/**
 * Port Interface to load a bank account
 * 
 * @author c.cordier
 *
 */
public interface LoadAccountPort {

	/**
	 * Load a bank account
	 * 
	 * @param id the identifier of the bank account
	 * @return the bank account
	 */
	Optional<BankAccount> load(Long id);
}