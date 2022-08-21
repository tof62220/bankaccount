package com.bankaccount.application.domain;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The account statement on a bank account
 * 
 * @author c.cordier
 *
 */
public class AccountStatement {

	public static final String STATEMENT_HEADER = "date | operation | amount | balance";

	private List<Operation> operations = new ArrayList<>();

	public void addOperation(Operation operation) {
		operations.add(operation);
	}

	public List<Operation> getOperations() {
		Collections.sort(operations);
		return List.copyOf(operations);
	}

	/**
	 * Prints operations in an output stream
	 * 
	 * @param printer the output stream
	 */
	public void printTo(PrintStream printer) {
		printer.println(STATEMENT_HEADER);
		for (Operation operation : getOperations()) {
			operation.printTo(printer);
		}
	}

}
