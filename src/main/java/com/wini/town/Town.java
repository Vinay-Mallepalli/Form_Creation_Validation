package com.wini.town;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wini.dao.Inserting;

@WebServlet("/hello")
public class Town extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String n = request.getParameter("tbname");
		String e1 = request.getParameter("tbemail");
		String s1 = request.getParameter("tbsub");
		String s2 = request.getParameter("tbsub1");
		
		int affectedRows = Inserting.insert(n, e1, s1,s2);
		
		
		
		if(affectedRows>0)
		{
			response.getWriter().append("<h1>Data is inserted..!</h1>");
			response.getWriter().append("<h3>Name: "+" "+n);
			response.getWriter().append("<h3>Email: "+" "+e1);
			response.getWriter().append("<h3>Subject 1: "+" "+s1);
			response.getWriter().append("<h3>Subject 2: "+" "+s2);
		}
		else
		{
			response.getWriter().append("<h1>Data is not inserted</h1>");
		}
	}

}
