package com.bankaccount.application.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bankaccount.application.BankaccountApplication;
import com.bankaccount.application.adapters.persistence.BankAccountRepository;
import com.bankaccount.application.service.BankAccountService;


/**
 * ean Configuration Class
 * 
 * @author c.cordier
 *
 */
@Configuration
@ComponentScan(basePackageClasses = BankaccountApplication.class)
public class BeanConfiguration {

	@Bean
	BankAccountService bankAccountService(BankAccountRepository repository) {
		return new BankAccountService(repository, repository);
	}
}
