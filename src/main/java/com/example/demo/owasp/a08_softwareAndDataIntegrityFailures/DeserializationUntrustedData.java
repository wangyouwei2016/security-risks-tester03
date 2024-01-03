package com.example.demo.owasp.a08_softwareAndDataIntegrityFailures;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * CWE-502: Deserialization of Untrusted Data
 * 
 * The product deserializes untrusted data without sufficiently verifying that the resulting data will be valid.
 * This code snippet deserializes an object from a file and uses it as a UI button:
 * This code does not attempt to verify the source or contents of the file before deserializing it. An attacker may be able to replace the intended file with a file that contains arbitrary malicious code which will be executed when the button is pressed.
 */
public class DeserializationUntrustedData {
	public void requestPackage(byte[] rData) throws IOException, ClassNotFoundException {
		try {
			File file = new File("object.obj");
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			@SuppressWarnings("unused")
			javax.swing.JButton button = (javax.swing.JButton) in.readObject();
			in.close();
			}
		finally {
		}
	}
}
