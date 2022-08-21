package com.bankaccount.application.port.incoming;

import java.math.BigDecimal;


/**
 * Port Interface that defines the Withdraxal Use Case
 * 
 * @author c.cordier
 *
 */
public interface WithdrawUseCase {

	/**
	 * Make a withdraw in a bank account
	 * 
	 * @param id the identifier of the bank account
	 * @param amount The amount to withdraw
	 */
	void withdraw(Long id, BigDecimal amount);
}