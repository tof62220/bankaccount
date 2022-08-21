package com.bankaccount.application.adapters.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bankaccount.application.domain.BankAccount;
import com.bankaccount.application.port.outgoing.LoadAccountPort;
import com.bankaccount.application.port.outgoing.SaveAccountPort;


/**
 * Repository Implementation to manage Bank Account
 * 
 * @author c.cordier
 *
 */
@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort {

	private SpringDataBankAccountRepository repository;

	public BankAccountRepository(SpringDataBankAccountRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<BankAccount> load(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(BankAccount bankAccount) {
		repository.save(bankAccount);
	}
}
