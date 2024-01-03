package com.example.demo.owasp.a02_cryptographicFailures;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 		
CWE-319: Cleartext Transmission of Sensitive Information
The product transmits sensitive or security-critical data in cleartext in a communication channel that can be sniffed by unauthorized actors.

 * 
 */
public class ClearTextTransmission {
	public void clearTextTransmission() {
		try {
				URL u = new URL("http://www.secret.example.org/");
				HttpURLConnection hu = (HttpURLConnection) u.openConnection();
				hu.setRequestMethod("PUT");
				hu.connect();
				OutputStream os = hu.getOutputStream();
				hu.disconnect();
				os.close();
			}
			catch (IOException e) {
				//...
			}
	}
}
