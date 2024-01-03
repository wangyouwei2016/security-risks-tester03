package com.example.demo.owasp.a07_identificationAuthenticationFailures;

import com.example.demo.owasp.a01_brokenAccessControl.BankAccount;

/**
 * 
 * CWE-306: Missing Authentication for Critical Function
 * In the following Java example the method createBankAccount is used to create a BankAccount object for a bank management application.
 * However, there is no authentication mechanism to ensure that the user creating this bank account object has the authority to create new bank accounts. Some authentication mechanisms should be used to verify that the user has the authority to create bank account objects.

The following Java code includes a boolean variable and method for authenticating a user. If the user has not been authenticated then the createBankAccount will not create the bank account object.
 */
public class MissingAuthenticationCriticalFunction {

	public BankAccount createBankAccount(String accountNumber, String accountType,
			String accountName, String accountSSN, double balance) {
			BankAccount account = new BankAccount();
			account.setAccountNumber(accountNumber);
			account.setAccountType(accountType);
			account.setAccountOwnerName(accountName);
			account.setAccountOwnerSSN(accountSSN);
			account.setBalance(balance);

			return account;
			}
}
