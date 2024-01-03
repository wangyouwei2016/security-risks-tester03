package com.example.demo.owasp.a05_securityMisconfiguration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;  


/**
 CWE-315: Cleartext Storage of Sensitive Information in a Cookie
 * 
 */
public class SecurityMisconfiguration {
	public void securityMisconfiguration(HttpServletResponse response, String acctID) {
		response.addCookie(new Cookie("userAccountID", acctID));

	}
}
