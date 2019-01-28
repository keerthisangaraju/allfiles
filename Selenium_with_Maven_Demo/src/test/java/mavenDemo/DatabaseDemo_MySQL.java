package mavenDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseDemo_MySQL
{

	@Test
	public void Database_TestCase() throws ClassNotFoundException, SQLException
	{
		
		// For loading the MYSQL java Driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
	    System.out.println("Driver Loaded");
	    
	    // Get the Connection with mysql database
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
	    
	    Statement stmt = conn.createStatement();
	    
	    ResultSet rs = stmt.executeQuery("select * from city where countrycode ='IND' and population > 1000000;");
	    
	    while(rs.next())
	    {
	    	String cityname = rs.getString("name");
	    	
	    	System.out.println("Cityname is "+cityname);
	    }
	}
}
