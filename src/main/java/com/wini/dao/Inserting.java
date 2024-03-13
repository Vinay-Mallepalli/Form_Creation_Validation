package com.wini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserting 
{
	public static int insert(String n, String e1, String s1, String s2)
	{
		Connection cn = null;
		Statement st = null;
		PreparedStatement ps = null;
		int affectedRows = 0;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/town","root", "admin");
			
			ps=cn.prepareStatement("insert into student(name,email,sub1,sub2) values(?,?,?,?)");
			ps.setString(1, n);
			ps.setString(2, e1);
			ps.setString(3,s1);
			ps.setString(4, s2);
			
			affectedRows=ps.executeUpdate();
		}
			
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try
				{
					ps.close();
				} 
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try
				{
					cn.close();
				} 
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return affectedRows;
	}
}
