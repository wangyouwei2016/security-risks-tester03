package com.example.demo.owasp.a05_securityMisconfiguration;

import java.io.IOException;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.owasp.a01_brokenAccessControl.BankManager;

public class BankManagerLoginServlet extends HttpServlet {
	/**
	CWE-537: Java Runtime Error Message Containing Sensitive Information
	In the example below, the BankManagerLoginServlet servlet class will process a login request to determine if a user is authorized to use the BankManager Web service. The doPost method will retrieve the username and password from the servlet request and will determine if the user is authorized. If the user is authorized the servlet will go to the successful login page. Otherwise, the servlet will raise a FailedLoginException and output the failed login message to the error page of the service.
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
			// Get username and password from login page request
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// Authenticate user
			BankManager bankMgr = new BankManager();
			boolean isAuthentic = bankMgr.authenticateUser(username, password);
			// If user is authenticated then go to successful login page
			if (isAuthentic) {
			request.setAttribute("login", new String("Login Successful."));
			getServletContext().getRequestDispatcher("/BankManagerServiceLoggedIn.jsp"). forward(request, response);
		}
		else {
		
			// Otherwise, raise failed login exception and output unsuccessful login message to error page
			throw new FailedLoginException("Failed Login for user " + username + " with password " + password);
		}
	} catch (FailedLoginException ex) {
	
		// output failed login message to error page
		request.setAttribute("error", new String("Login Error"));
		request.setAttribute("message", ex.getMessage());
		getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
	}
	}
}