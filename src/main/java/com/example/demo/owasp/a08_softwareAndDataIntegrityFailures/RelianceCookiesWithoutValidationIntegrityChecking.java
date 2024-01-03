package com.example.demo.owasp.a08_softwareAndDataIntegrityFailures;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * CWE-565: Reliance on Cookies without Validation and Integrity Checking
The product relies on the existence or values of cookies when performing security-critical operations, but it does not properly ensure that the setting is valid for the associated user.
The following code excerpt reads a value from a browser cookie to determine the role of the user.

It is easy for an attacker to modify the "role" value found in the locally stored cookie, allowing privilege escalation.


 */
public class RelianceCookiesWithoutValidationIntegrityChecking {
	public void checkCookies(HttpServletRequest request, String userRole) {
		Cookie[] cookies = request.getCookies();
		for (int i =0; i< cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("role")) {
				userRole = c.getValue();
			}
		}
	}
}
