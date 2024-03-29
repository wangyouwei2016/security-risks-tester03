package com.example.demo.owasp.a02_cryptographicFailures;

import java.util.Date;
import java.util.Random;

/**
 * 
 * CWE-331: Insufficient Entropy
 * The following code uses a statistical PRNG to create a URL for a receipt that remains active for some period of time after a purchase.
This code uses the Random.nextInt() function to generate "unique" identifiers for the receipt pages it generates. Because Random.nextInt() is a statistical PRNG, it is easy for an attacker to guess the strings it generates. Although the underlying design of the receipt system is also faulty, it would be more secure if it used a random number generator that did not produce predictable receipt identifiers, such as a cryptographic PRNG.

 */
public class InsufficientEntropy {
	String GenerateReceiptURL(String baseUrl) {
			Random ranGen = new Random();
			ranGen.setSeed((new Date()).getTime());
			return(baseUrl + ranGen.nextInt(400000000) + ".html");
		}
}
