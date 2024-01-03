package com.example.demo.owasp.a03_injection;


import java.io.IOException;

import javax.servlet.http.HttpServlet;

/**
 * CWE-77: Improper Neutralization of Special Elements used in a Command ('Command Injection')
 * The product constructs all or part of a command using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended command when it is sent to a downstream component.
 * 
 */
public class commandInjection extends HttpServlet{
	public static String INITCMD = "powershell";
	private static final long serialVersionUID = 1L;

	public void runCommandInjection(HttpServlet request) throws IOException {
		String btype = request.getInitParameter("backuptype");
		String cmd = new String("cmd.exe /K \" c:\\util\\rmanDB.bat "+btype+"&&c:\\utl\\cleanup.bat\"");
		@SuppressWarnings("unused")
		Process process = Runtime.getRuntime().exec(cmd);
		String home = System.getProperty("APPHOME");
		/**
		 * 
		 * The following code from a system utility uses the system property APPHOME to determine the directory in which it is installed and then executes an initialization script based on a relative path from the specified directory.
		 */
		cmd = home + INITCMD;
		java.lang.Runtime.getRuntime().exec(cmd);
	}

}
