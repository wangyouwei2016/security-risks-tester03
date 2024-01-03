package com.example.demo.owasp.a09_securityLoggingMonitoringFailures;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.owasp.a01_brokenAccessControl.BankAccount;
import com.example.demo.owasp.a01_brokenAccessControl.BankManager;
import com.example.demo.owasp.a01_brokenAccessControl.DatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ImproperOutputNeutralizationLogs {
	Logger log = Logger.getLogger("improperLog");
	/**
	 * 
	 * 
	 * CWE-117: Improper Output Neutralization for Logs
		The following web application code attempts to read an integer value from a request object. If the parseInt call fails, then the input is logged with an error message indicating what happened.
		
		If a user submits the string "twenty-one" for val, the following entry is logged:
		
		INFO: Failed to parse val=twenty-one
		However, if an attacker submits the string "twenty-one%0a%0aINFO:+User+logged+out%3dbadguy", the following entry is logged:
		
		INFO: Failed to parse val=twenty-one
		INFO: User logged out=badguy
		Clearly, attackers can use this same mechanism to insert arbitrary log entries.
	 */
	public void improperLog(HttpServletRequest request) {
		String val = request.getParameter("val");
		try {

			int value = Integer.parseInt(val);
		}
		catch (NumberFormatException ne) {
			log.info("Failed to parse val = " + val);
		}
	}
	/**
	 * 
	 * CWE-532: Insertion of Sensitive Information into Log File
		Information written to log files can be of a sensitive nature and give valuable guidance to an attacker or expose sensitive user information.
		In the example below, the method getUserBankAccount retrieves a bank account object from a database using the supplied username and account number to query the database. 
		If an SQLException is raised when querying the database, an error message is created and output to a log file.
		The error message that is created includes information about the database query that may contain sensitive information about the database or query logic. 
		In this case, the error message will expose the table name and column names used in the database. This data could be used to simplify other attacks, such as SQL injection (CWE-89) to directly access the database.
	 * 
	 * @param username
	 * @param accountNumber
	 * @return
	 */
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
		return false;
	}
}
