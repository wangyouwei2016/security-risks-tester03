package com.example.demo.owasp.a04_insecureDesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * CWE-73: External Control of File Name or Path
 * The following code uses input from a configuration file to determine which file to open and echo back to the user. If the program runs with privileges and malicious users can change the configuration file, they can use the program to read any file on the system that ends with the extension .txt.
 */
public class ExternalFileControl {
	public void xternalFile(Properties props) throws IOException {
		FileInputStream fis = new FileInputStream(props.getProperty("sub")+".txt");
		int amt = fis.read();
		System.out.println(amt);
		fis.close();
		
	}
}
