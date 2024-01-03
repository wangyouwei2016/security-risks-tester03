package com.example.demo.owasp.a04_insecureDesign;

import javax.servlet.http.HttpSession;

/**
 * CWE-579: J2EE Bad Practices: Non-serializable Object Stored in Session
The product stores a non-serializable object as an HttpSession attribute, which can hurt reliability.

 */
public class ObjectStoredInSession {
	String globName;
	String globValue;

	public void addToSession(HttpSession session) {
		session.setAttribute("glob", this);
	}
}
