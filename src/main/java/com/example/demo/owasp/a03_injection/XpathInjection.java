package com.example.demo.owasp.a03_injection;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
/*
 * 
 * CWE-643 Improper Neutralization of Data within XPath Expressions ('XPath Injection')
 */
public class XpathInjection {
	public void xpathCase() throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		Login login = new Login();
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression xlogin = xpath.compile("//users/user[login/text()='" + login.getUserName() + "' and password/text() = '" + login.getPassword() + "']/home_dir/text()");
		Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("db.xml"));
		String homedir = xlogin.evaluate(d);
		System.out.println(homedir);
	}

}
