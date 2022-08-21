package com.bankaccount.application.port.outgoing;

import com.bankaccount.application.domain.BankAccount;


/**
 * Port Interface to save a bank account
 * 
 * @author c.cordier
 *
 */
public interface SaveAccountPort {

	/**
	 * Save a bank account
	 * 
	 * @param bankAccount the bank account to be saved
	 */
	void save(BankAccount bankAccount);
}