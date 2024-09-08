package com.batchTask.p1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/dum")
public class Calculator extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		
		
		int a=Integer.parseInt(req.getParameter("first"));
		int b=Integer.parseInt(req.getParameter("second"));
		
		pw.print("<h1>Addition of two number is : "+(a+b)+"</h1>");
		
		
		
		
		
		
		
	}

}
