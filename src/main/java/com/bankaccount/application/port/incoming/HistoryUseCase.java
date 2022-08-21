package com.bankaccount.application.port.incoming;

import java.util.List;

import com.bankaccount.application.domain.Operation;


/**
 * Port Interface that defines the history Use Case
 * 
 * @author c.cordier
 */
public interface HistoryUseCase {

	/**
	 * Returns the bank account's operations ordered by date
	 * 
	 * @param id the identifier of the bank account
	 * @return the operations ordered by date
	 */
	List<Operation> history(Long id);
}