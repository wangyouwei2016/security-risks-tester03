package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.codeqa.InsecureRandomNumber;

import org.junit.Assert;

@SpringBootTest
public class SecurityTesterApplicationTests {

	@Test
	public void testHardcode() {
		String randomPassword = InsecureRandomNumber.generateSecureRandomPassword();
		Assert.assertEquals(randomPassword.length(), 10);
	}

}
