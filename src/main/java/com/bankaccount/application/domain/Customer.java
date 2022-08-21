package com.bankaccount.application.domain;

import java.util.Objects;


/**
 * A Customer of the bank
 * 
 * @author c.cordier
 *
 */
public class Customer {

	private String clientNumber;

	private String firstname;

	private String lastname;

	public Customer(String clientNumber, String firstname, String lastname) {
		super();
		this.clientNumber = clientNumber;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * Returns the field 'clientNumber'
	 *
	 * @return the clientNumber
	 */
	public String getClientNumber() {
		return clientNumber;
	}

	/**
	 * Returns the field 'firstname'
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Returns the field 'lastname'
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientNumber, firstname, lastname);
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
		Customer other = (Customer) obj;
		return Objects.equals(clientNumber, other.clientNumber) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname);
	}

}
