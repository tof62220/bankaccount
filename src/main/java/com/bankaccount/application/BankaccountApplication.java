package com.bankaccount.application;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bankaccount.application.adapters.persistence.BankAccountRepository;
import com.bankaccount.application.domain.BankAccount;
import com.bankaccount.application.domain.Customer;


@SpringBootApplication
public class BankaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankaccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner bootstrapData(BankAccountRepository repository) {
		return (args) -> {
			Customer customer = new Customer("0001", "Gastion", "Lagaffe");
			BigDecimal initialBalance = BigDecimal.valueOf(1000);
			BankAccount bankAccount = new BankAccount(1L, "0001", initialBalance, customer);
			repository.save(bankAccount);
		};
	}

}
