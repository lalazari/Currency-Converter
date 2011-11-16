package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.net.*;




public class CurrencySelect extends HttpServlet {
	
public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	//out.println("Under Construction Currency Converter<br>");
	String c = request.getParameter("From");
	String c2 = request.getParameter("To");
	String amount= request.getParameter("Amounts");
	if(c.equals(c2)) {
		out.println("<br>Bad Currencies Arguments");
		out.println("<br> " + c +" is the same curruncy with " + c2);
	}
	else {
		out.println("<br>You Select to Convert From: " + c);
		out.println("<br>To: " + c2);
		out.println("<br>Selected Amount: " + amount);

		
		try{
			
			Double.valueOf(amount);	
			double d = Double.parseDouble(amount);
			if(d<0) {
				out.print("<br>Please give a non-Negative number");
				out.print("<br>there is no meaning to tell someone that");
				
				
			}
			
			
			
			String path;
			String s1;
			String s2;
			String s3;
			String s4;
			String s5;
			path= amount + c;

			URL convert = new URL("http://www.google.com/ig/calculator?hl=en&q="+path+"=?"+c2);
			BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
			String answer = in.readLine();
			in.close();
			
			int k=0;
			int l=0;
			char a=',';
			char b;
			int i=0,j=0;

			for(i=0; i<answer.length(); i++) {
				b=answer.charAt(i);
				if(b==a) {
					k=i;
					break;
					}
			}
			s1=answer.substring(k+1);
			
			for(j=0; j<s1.length(); j++) {
				b=s1.charAt(j);
				if(b==a) {
					l=j;
					break;
				}
			}
			s2=s1.substring(5,l);
			s3=answer.substring(7,k-1);
			s4=s3.replaceAll("�","."); 
			s5=s2.replaceAll("�",".");



			
			out.println("<br>The " +s4+" is-->>> "+s5);

		} 
		
		
		catch (NumberFormatException e) {
			out.println("<br>---->>Bad number format Please give a number");        		
		}
		
			
				
		catch (MalformedURLException mue) {
			System.exit(1);
		}	
		catch (IOException ioe) {
			System.exit(1);
		}


		

		}
		
	}

	
}


