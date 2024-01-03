package com.example.demo.owasp.a07_identificationAuthenticationFailures;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * CWE-290: Authentication Bypass by Spoofing
 * This attack-focused weakness is caused by incorrectly implemented authentication schemes that are subject to spoofing attacks.

 */
public class AuthenticationBypassSpoofing {

	/**
	 * 
	 * The following code authenticates users.
	 * The authentication mechanism implemented relies on an IP address for source validation. 
	 * If an attacker is able to spoof the IP, they may be able to bypass the authentication mechanism.
	 */
	public static String APPROVED_IP = "123.123.123.123";
	public boolean authUser(HttpServletRequest request) {
		String sourceIP = request.getRemoteAddr();
		if (sourceIP != null && sourceIP.equals(APPROVED_IP)) {
			boolean authenticated = true;
			return authenticated;

		}else {
			boolean authenticated = false;
			return authenticated;

		}
	}
}
