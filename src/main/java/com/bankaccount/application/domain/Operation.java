package com.bankaccount.application.domain;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/**
 * An operation on a bank account
 * 
 * @author c.cordier
 *
 */
public class Operation implements Comparable<Operation> {

	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

	private OffsetDateTime date;

	private OperationType type;

	private BigDecimal amount;

	private BigDecimal balanceAfterOperation;

	public Operation(OperationType type, BigDecimal amount, BigDecimal balanceAfterOperation) {
		this.type = type;
		this.amount = amount.setScale(2, RoundingMode.HALF_EVEN);
		this.balanceAfterOperation = balanceAfterOperation.setScale(2, RoundingMode.HALF_EVEN);
		this.date = OffsetDateTime.now();
	}

	/**
	 * Returns the field 'date'
	 *
	 * @return the date
	 */
	public OffsetDateTime getDate() {
		return date;
	}

	/**
	 * Returns the field 'type'
	 *
	 * @return the type
	 */
	public OperationType getType() {
		return type;
	}

	/**
	 * Returns the field 'amount'
	 *
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Returns the field 'balanceAfterOperation'
	 *
	 * @return the balanceAfterOperation
	 */
	public BigDecimal getBalanceAfterOperation() {
		return balanceAfterOperation;
	}

	/**
	 * Prints operation in an output stream
	 * 
	 * @param printer the output stream
	 */
	public void printTo(PrintStream printer) {
		StringBuilder builder = new StringBuilder();
		builder.append(date.format(DATE_FORMATTER));
		builder.append(" | ");
		builder.append(type.name());
		builder.append(" | ");
		builder.append(amount.toString());
		builder.append(" | ");
		builder.append(balanceAfterOperation.toString());
		builder.append(" | ");
		printer.println(builder.toString());
	}

	@Override
	public int compareTo(Operation otherOperation) {
		return this.date.compareTo(otherOperation.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, balanceAfterOperation, date, type);
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
		Operation other = (Operation) obj;
		return Objects.equals(amount, other.amount)
				&& Objects.equals(balanceAfterOperation, other.balanceAfterOperation)
				&& Objects.equals(date, other.date) && type == other.type;
	}

}
