package com.sistemas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OlaMundo extends HttpServlet {

	private static final long serialVersionUID = -7344972349236868512L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("Ola mundo!!! Java é legal");
		out.println("</body>");
		out.println("</html>");	
		out.close();

	}

}
