package com.example.demo.owasp.a01_brokenAccessControl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * CWE-200: Exposure of Sensitive Information to an Unauthorized Actor
 * The product exposes sensitive information to an actor that is not explicitly authorized to have access to that information.
 * 
 */
public class BankAccount {
	public BankAccount getUserBankAccount(String username, String accountNumber) {
		BankAccount userAccount = null;
		String query = null;
		try {
		if (isAuthorizedUser(username)) {
			query = "SELECT * FROM accounts WHERE owner = "
			+ username + " AND accountID = " + accountNumber;
			DatabaseManager dbManager = new DatabaseManager();
			Connection conn = dbManager.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet queryResult = stmt.executeQuery(query);
			userAccount = (BankAccount)queryResult.getObject(accountNumber);
		}
		} catch (SQLException ex) {
			String logMessage = "Unable to retrieve account information from database,\nquery: " + query;
			Logger.getLogger(BankManager.class.getName()).log(Level.SEVERE, logMessage, ex);
		}
			return userAccount;
		}

	private boolean isAuthorizedUser(String username) {
		// TODO Auto-generated method stub
		return true;
	}

	public void setAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void setAccountType(String accountType) {
		// TODO Auto-generated method stub
		
	}

	public void setAccountOwnerName(String accountName) {
		// TODO Auto-generated method stub
		
	}

	public void setAccountOwnerSSN(String accountSSN) {
		// TODO Auto-generated method stub
		
	}

	public void setBalance(double balance) {
		// TODO Auto-generated method stub
		
	}
}
