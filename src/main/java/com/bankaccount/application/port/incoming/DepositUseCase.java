package com.bankaccount.application.port.incoming;

import java.math.BigDecimal;


/**
 * Port Interface that defines the Deposit Use Case
 * 
 * @author c.cordier
 *
 */
public interface DepositUseCase {

	/**
	 * Make a deposit in a bank account
	 * 
	 * @param id the identifier of the bank account
	 * @param amount The amount to deposit
	 */
	void deposit(Long id, BigDecimal amount);
}