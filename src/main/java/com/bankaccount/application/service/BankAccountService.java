package com.bankaccount.application.service;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import com.bankaccount.application.domain.BankAccount;
import com.bankaccount.application.domain.Operation;
import com.bankaccount.application.port.incoming.DepositUseCase;
import com.bankaccount.application.port.incoming.HistoryUseCase;
import com.bankaccount.application.port.incoming.PrintingUseCase;
import com.bankaccount.application.port.incoming.WithdrawUseCase;
import com.bankaccount.application.port.outgoing.LoadAccountPort;
import com.bankaccount.application.port.outgoing.SaveAccountPort;


/**
 * Service to manage bank accounts
 * 
 * @author c.cordier
 *
 */
public class BankAccountService implements DepositUseCase, WithdrawUseCase, HistoryUseCase, PrintingUseCase {

	private LoadAccountPort loadAccountPort;
	private SaveAccountPort saveAccountPort;

	public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
		this.loadAccountPort = loadAccountPort;
		this.saveAccountPort = saveAccountPort;
	}

	@Override
	public void deposit(Long id, BigDecimal amount) {
		BankAccount account = loadAccountPort.load(id)
				.orElseThrow(NoSuchElementException::new);

		account.deposit(amount);

		saveAccountPort.save(account);
	}

	@Override
	public void withdraw(Long id, BigDecimal amount) {
		BankAccount account = loadAccountPort.load(id)
				.orElseThrow(NoSuchElementException::new);

		account.withdraw(amount);

		saveAccountPort.save(account);
	}

	@Override
	public List<Operation> history(Long id) {
		BankAccount account = loadAccountPort.load(id)
				.orElseThrow(NoSuchElementException::new);

		return account.getHistory();
	}

	@Override
	public void print(Long id, PrintStream printer) {
		BankAccount account = loadAccountPort.load(id)
				.orElseThrow(NoSuchElementException::new);

		account.printStatement(printer);
	}
}
