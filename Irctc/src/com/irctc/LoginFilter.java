package com.irctc;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// Change the URL pattern to match your secured pages
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		if (session != null && session.getAttribute("LogStatus") != null
				&& session.getAttribute("LogStatus").equals(1)) {
			// If session variable "log" exists and equals 1, dispatch to a secure page
			httpRequest.getRequestDispatcher("TicketsBooking.html").forward(request, response);
		} else {
			// Otherwise, redirect to another page
			httpRequest.getRequestDispatcher("LoginPage.html").forward(request, response);
		}
	}

	// Other methods of the Filter interface are left unimplemented
}
