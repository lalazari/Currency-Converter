package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class ListenServlet extends HttpServlet {
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		ReObj reobj = (ReObj) getServletContext().getAttribute("reobj");
		response.sendRedirect(response.encodeRedirectURL(reobj.getRedirectLink()));

	}
}

