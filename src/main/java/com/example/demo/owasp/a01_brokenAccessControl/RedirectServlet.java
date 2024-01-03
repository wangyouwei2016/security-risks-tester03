package com.example.demo.owasp.a01_brokenAccessControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CWE-601: URL Redirection to Untrusted Site ('Open Redirect')
   A web application accepts a user-controlled input that specifies a link to an external site, and uses that link in a Redirect. This simplifies phishing attacks.
   The following code is a Java servlet that will receive a GET request with a url parameter in the request to redirect the browser to the address specified in the url parameter. The servlet will retrieve the url parameter value from the request and send a response to redirect the browser to the url address.
 * 
 */
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 2760656118035717329L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getQueryString();
		if (query.contains("url")) {
			String url = request.getParameter("url");
			response.sendRedirect(url);
		}
	}
}
