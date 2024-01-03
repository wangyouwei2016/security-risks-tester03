package com.example.demo.owasp.a02_cryptographicFailures;

/**
 * CWE-321: Use of Hard-coded Cryptographic Key
 * The use of a hard-coded cryptographic key significantly increases the possibility that encrypted data may be recovered.
 * 
 */
public class VerifyAdmin {
	public boolean verifyAdmin(String password) {
		if (password.equals("68af404b513073584c4b6f22b6c63e6b")) {
			System.out.println("Entering Diagnostic Mode...");
			return true;
		}
			System.out.println("Incorrect Password!");
			return false;
		}
}
