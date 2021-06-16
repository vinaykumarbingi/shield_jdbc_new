package com.dbconnection;

import java.sql.*;

public class DatabaseConnection 
{
	private static Connection con = null;
	  
    static
    {
        String url = "jdbc:mysql:// localhost:3306/vinay";
        String user = "root";
        String pass = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
