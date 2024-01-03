package com.example.demo.owasp.a04_insecureDesign;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

/**
 * CWE-73: External Control of File Name or Path
Example 1

The following code uses input from an HTTP request to create a file name. The programmer has not considered the possibility that an attacker could provide a file name such as "../../tomcat/conf/server.xml", which causes the application to delete one of its own configuration files (CWE-22).
 * 
 */
public class InsecureDesign {
	public static void insecureDesign(HttpServletRequest request) {
		String rName = request.getParameter("reportName");
		File rFile = new File("/usr/local/apfr/reports/" + rName);
		rFile.delete();

	}
}
