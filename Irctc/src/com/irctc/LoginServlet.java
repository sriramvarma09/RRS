package com.irctc;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		UserValidation ul = new UserValidation();
		int rescode = ul.validate(username, password);
		HttpSession session = req.getSession();
		res.setContentType("application/json");
		if (rescode == 1) {
			res.getWriter().write("{\"response\":1}");
			session.setAttribute("LogStatus", 1);
		} else {
			res.getWriter().write("{\"response\":0}");
			session.setAttribute("LogStatus", 0);
		}
	}
}
