package com.bankaccount.application.adapters.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankaccount.application.domain.Operation;
import com.bankaccount.application.port.incoming.DepositUseCase;
import com.bankaccount.application.port.incoming.HistoryUseCase;
import com.bankaccount.application.port.incoming.PrintingUseCase;
import com.bankaccount.application.port.incoming.WithdrawUseCase;


/**
 * REST Controller Api to manage Bank Account
 * 
 * @author c.cordier
 *
 */
@RestController
@RequestMapping("v1.0/accounts")
public class BankAccountController {

	private final DepositUseCase depositUseCase;
	private final WithdrawUseCase withdrawUseCase;
	private final HistoryUseCase historyUseCase;
	private final PrintingUseCase printingUseCase;

	public BankAccountController(DepositUseCase depositUseCase,
			WithdrawUseCase withdrawUseCase,
			HistoryUseCase historyUseCase,
			PrintingUseCase printingUseCase) {
		this.depositUseCase = depositUseCase;
		this.withdrawUseCase = withdrawUseCase;
		this.historyUseCase = historyUseCase;
		this.printingUseCase = printingUseCase;
	}

	/**
	 * Make a deposit in the bank account
	 * 
	 * @param id identifier of the bank account
	 * @param amount The amount to deposit
	 */
	@PostMapping(value = "/{id}/deposits/{amount}")
	public void deposit(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
		depositUseCase.deposit(id, amount);
	}

	/**
	 *
	 * Make a withdrawal from the bank account
	 * 
	 * @param id identifier of the bank account
	 * @param amount The amout to withdraw
	 */
	@PostMapping(value = "/{id}/withdraws/{amount}")
	public void withdraw(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
		withdrawUseCase.withdraw(id, amount);
	}

	/**
	 * Returns the history of operations on the bank account
	 * 
	 * @param id identifier of the bank account
	 * @return
	 */
	@GetMapping(value = "/{id}/history")
	public List<Operation> history(@PathVariable final Long id) {
		return historyUseCase.history(id);
	}

	/**
	 * Print the history of operations on the bank account
	 * 
	 * @param id identifier of the bank account
	 * @return A file to download with the history of operations on the bank account
	 * @throws IOException
	 */
	@GetMapping(value = "/{id}/print")
	public ResponseEntity<Resource> print(@PathVariable final Long id) throws IOException {

		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(outputStream)) {

			printingUseCase.print(id, printStream);

			InputStreamResource resource = new InputStreamResource(
					new ByteArrayInputStream(outputStream.toByteArray()));

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=statement.txt");
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			return ResponseEntity.ok()
					.headers(headers)
					.contentLength(outputStream.size())
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(resource);
		}

	}
}
