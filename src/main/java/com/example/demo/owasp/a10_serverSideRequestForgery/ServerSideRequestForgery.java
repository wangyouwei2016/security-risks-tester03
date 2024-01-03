package com.example.demo.owasp.a10_serverSideRequestForgery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;  
/**
 * 
 * A10:2021 – Server-Side Request Forgery (SSRF)
 * 
 * SSRF flaws occur whenever a web application is fetching a remote resource without validating the user-supplied URL. It allows an attacker to coerce the application to send a crafted request to an unexpected destination, even when protected by a firewall, VPN, or another type of network access control list (ACL).
 * 
 */
public class ServerSideRequestForgery {
	public static void ssrf() {
        String targetURL = "http://internal.example.com/sensitive-data"; // 替换为内部服务的URL  
        try {  
            URL url = new URL(targetURL);  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
            connection.setRequestMethod("GET");  
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
            String line;  
            while ((line = reader.readLine()) != null) {  
                System.out.println(line);  
            }  
            reader.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  		
	}
}
