package com.bankaccount.application.domain;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;


/**
 * A bank account
 * 
 * @author c.cordier
 *
 */
public class BankAccount {

	private Long id;

	private String accountNumber;

	private Customer customer;

	private BigDecimal currentBalance;

	private AccountStatement statement;

	public BankAccount(Long id, String accountNumber, BigDecimal currentBalance, Customer customer) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance.setScale(2, RoundingMode.HALF_EVEN);
		this.customer = customer;
		this.statement = new AccountStatement();
	}

	/**
	 * Returns the field 'id'
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the field 'accountNumber'
	 *
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Returns the field 'customer'
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns the field 'currentBalance'
	 *
	 * @return the currentBalance
	 */
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * Returns the field 'statement'
	 *
	 * @return the statement
	 */
	public AccountStatement getStatement() {
		return statement;
	}

	/**
	 * Returns the operations ordered by date
	 * 
	 * @return the operations ordered by date
	 */
	public List<Operation> getHistory() {
		return this.statement.getOperations();
	}

	/**
	 * Make a deposit in this bank account
	 * 
	 * @param amount The amount to deposit
	 */
	public void deposit(BigDecimal amount) {
		this.currentBalance = currentBalance.add(amount).setScale(2, RoundingMode.HALF_EVEN);
		Operation operation = new Operation(OperationType.DEPOSIT, amount, currentBalance);
		recordOperation(operation);
	}

	/**
	 * Make a withdrawal from this bank account
	 * 
	 * @param amount The amout to withdraw
	 */
	public void withdraw(BigDecimal amount) {
		this.currentBalance = currentBalance.subtract(amount).setScale(2, RoundingMode.HALF_EVEN);
		Operation operation = new Operation(OperationType.WITHDRAWAL, amount, currentBalance);
		recordOperation(operation);
	}

	/**
	 * Prints statement account in an output stream
	 * 
	 * @param printer the output stream
	 */
	public void printStatement(PrintStream printer) {
		statement.printTo(printer);
	}

	/**
	 * Records an operation in account statement
	 * 
	 * @param operation
	 */
	private void recordOperation(Operation operation) {
		statement.addOperation(operation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, currentBalance, customer, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accountNumber, other.accountNumber)
				&& Objects.equals(currentBalance, other.currentBalance) && Objects.equals(customer, other.customer)
				&& Objects.equals(id, other.id);
	}

}
