package com.bankaccount.application.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.jupiter.api.Test;


class BankAccountTest {

	@Test
	void testDeposit() throws Exception {
		Customer customer = new Customer("0001", "Gastion", "Lagaffe");
		BankAccount account = new BankAccount(1L, "0001", BigDecimal.valueOf(1000), customer);

		account.deposit(BigDecimal.valueOf(1000));

		assertEquals(BigDecimal.valueOf(2000).setScale(2, RoundingMode.HALF_EVEN), account.getCurrentBalance());
	}

	@Test
	void testWithdraw() throws Exception {
		Customer customer = new Customer("0001", "Gastion", "Lagaffe");
		BankAccount account = new BankAccount(1L, "0001", BigDecimal.valueOf(1000), customer);

		account.withdraw(BigDecimal.valueOf(500));

		assertEquals(BigDecimal.valueOf(500).setScale(2, RoundingMode.HALF_EVEN), account.getCurrentBalance());
	}

	@Test
	void testGetHistory() throws Exception {
		Customer customer = new Customer("0001", "Gastion", "Lagaffe");
		BankAccount account = new BankAccount(1L, "0001", BigDecimal.valueOf(1000), customer);

		account.deposit(BigDecimal.valueOf(1000));
		account.withdraw(BigDecimal.valueOf(500));

		assertEquals(BigDecimal.valueOf(1500).setScale(2, RoundingMode.HALF_EVEN), account.getCurrentBalance());

		List<Operation> operations = account.getHistory();

		assertEquals(2, operations.size());
		Operation deposit = operations.get(0);

		assertNotNull(deposit.getDate());
		assertEquals(OperationType.DEPOSIT, deposit.getType());
		assertEquals(BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_EVEN), deposit.getAmount());
		assertEquals(BigDecimal.valueOf(2000).setScale(2, RoundingMode.HALF_EVEN), deposit.getBalanceAfterOperation());

		Operation withdraw = operations.get(1);

		assertNotNull(withdraw.getDate());
		assertEquals(OperationType.WITHDRAWAL, withdraw.getType());
		assertEquals(BigDecimal.valueOf(500).setScale(2, RoundingMode.HALF_EVEN), withdraw.getAmount());
		assertEquals(BigDecimal.valueOf(1500).setScale(2, RoundingMode.HALF_EVEN), withdraw.getBalanceAfterOperation());

	}

}
