
package GoFish;

/* 
 * @author Kim Tang
 * @version 1.0
 */

import java.sql.*;

public class Driver {

	public static void main(String[] args) 
	{
		//you can use main to test out if your database with queries works if you want
		// just adjust values here and then copy and paste the content of a method and insert it in main below the variables
		
		String username = "kim";
		String password = "kim";
		int score = 2;
		
		
	}
	
	//method to display the entire database 
	//--- currently not used
	
	public static void getFullData()
	{
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from scores");
			
			//4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("username") + ", " + myRs.getInt("scores"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	//method to get the current score in total for a certain player (sum of scores from all played games), if username doesn't exist, score equals 0
	
	public static void getPlayerScore(String username)
	{
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from scores where username = '" + username + "' order by scores desc;");
			
			//4. Process the result set
			while (myRs.next()) 
			{
				System.out.println(myRs.getString("username") + "   " +  myRs.getInt("scores"));
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	//method to add a new entry for a player with score from played game
	
	public static void addScore(String username, int score)
	{
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			myStmt.executeUpdate("insert into scores (username, scores) values ('" + username + "', '" + score + "');");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	//getting the password for the respective username
	public static String getPlayerPassword(String username)
	{
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
	
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select password from login where username = '" + username + "'");
			
			//4. Process the result set if not empty
			while (myRs.next() && myRs.getString("password") != null)
			{
				return myRs.getString("password");
			}
		    return myRs.getString("password");
		}
		catch (Exception exc) {
			exc.printStackTrace();
			return "ThisPasswordDoesReallyNotExistSoPleaseEnterANewPasswordAndLetNobodySeeThisCodeBecauseItIsSoBad";
		}
	}
	
	//check if username already exists
	public static Boolean usernameExists(String username)
	{
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select username from login where username = '" + username + "'");
			
			
			//4. checking if string (username) is existing
			if(myRs.next())
			{
				return true;
			}
			else return false;
		}
		catch (Exception exc) {
			exc.printStackTrace();
			return null;
			
		}
	}
	
	//add a new user with password into login table
	public static void addUser(String username, String password)
	{
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			myStmt.executeUpdate("insert into login (username, password) values ('" + username + "', '" + password + "')");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void addTime(double t)
	{
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			myStmt.executeUpdate("insert into time (timed) values ('" + t + "');");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
