package com.example.web;

import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
			
		ServletContext sc = event.getServletContext();

		String RedirectLink = sc.getInitParameter("redirectlink");
	
		ReObj R = new ReObj(RedirectLink);
	
		sc.setAttribute("reobj", R);
	}

	public void contextDestroyed(ServletContextEvent event) {
		//nothing here
	}
}
