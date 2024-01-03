package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.owasp.a01_brokenAccessControl.ImproperLimitationPathname;
import com.example.demo.owasp.a03_injection.SQLInjection;
import com.example.demo.owasp.a06_vulnerableOutdatedComponents.VulnerableOutdatedComponents;
import com.example.demo.owasp.a07_identificationAuthenticationFailures.IdentificationAuthenticationFailures;
import com.example.demo.owasp.a10_serverSideRequestForgery.ServerSideRequestForgery;

@RestController
public class GreetingsController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hello world! This is a project to test vulnerabilities to test GitHub Enterprise and DevOps platform AS-IS security tools.";
	}
	

	@GetMapping("/injection")
	public String injection(@RequestParam(value = "usernamne", defaultValue = "admin") String username,
			@RequestParam(value = "password", defaultValue = "admin123") String password) throws Exception {
		SQLInjection.sqlInjection(username, password);
		return "A03:injection!";
	}	
	@GetMapping("/outdated-component")
	public String outdatedComp() throws IOException{
		VulnerableOutdatedComponents.vulnerableOutdatedComponents();
		return "A06:2021-Vulnerable and Outdated Components";
	}
	

	@GetMapping("/identify-auth")
	public String identifyAndAuth(@RequestParam(value = "username", defaultValue = "admin") String userName){
		IdentificationAuthenticationFailures.authenticate(userName);
		IdentificationAuthenticationFailures.isAdmin(userName);
		return "A07:2021-Identification and Authentication Failure";
	}
	
	@GetMapping("/ssrf")
	public String ssrf(){
		ServerSideRequestForgery.ssrf();
		return "A10:SSRF";
	}
	
	@GetMapping("/path-traversal")
	public String pathTraversal(@RequestParam(value = "filePath", defaultValue = "/safe_dir/") String filePath){
		ImproperLimitationPathname.improperLimitationPathname("/safe_dir/../important.dat");
		return "CWE-22: Improper Limitation of a Pathname to a Restricted Directory ('Path Traversal')";
	}
	
}
