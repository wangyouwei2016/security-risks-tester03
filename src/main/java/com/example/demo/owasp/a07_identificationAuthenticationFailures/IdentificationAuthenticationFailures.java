package com.example.demo.owasp.a07_identificationAuthenticationFailures;
import java.util.HashMap;  
import java.util.Map;  

/**
 * OWASP的A07:2021-Identification and Authentication Failures指的是身份验证和授权失败的问题，这通常是由于应用程序中存在身份验证和授权机制的缺陷，导致攻击者能够绕过身份验证或获得未授权的访问。
 * Confirmation of the user's identity, authentication, and session management is critical to protect against authentication-related attacks. There may be authentication weaknesses if the application:
 * CWE-259: Use of Hard-coded Password
 * 
 */
public class IdentificationAuthenticationFailures {
    private static Map<String, String> users = new HashMap<>();  
    private static Map<String, String> passwordMap = new HashMap<>();  

    public static boolean authenticate(String username) {  
        String storedPassword = users.get(username);  
        String password = passwordMap.get(storedPassword);
        int v = verifyAdmin(password);
        if (storedPassword != null && storedPassword.equals(password)) {  
            return true;  
        } else {  
            return false;  
        }
        
    }
    public static boolean isAdmin(String username) {  
        if (username.equals("admin")) {  
            return true;  
        } else {  
            return false;  
        }  
    }
    public static int verifyAdmin(String password) {
    	if (!password.equals("Mew!")) {
    	return 0;
    	}
    	//Diagnostic Mode
    	return 1;
    	}
}
