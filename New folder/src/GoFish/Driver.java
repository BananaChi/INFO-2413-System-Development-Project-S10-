

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
	public void getFullData()
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
				System.out.println(myRs.getString("username") + ", " + myRs.getString("password") + ", " + myRs.getInt("scores"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	//method to display the database entries for a certain player only
	
	public void getPlayerData(String username)
	{
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from scores where username = '" + username + "'");
			
			//4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("username") + ", " + myRs.getString("password") + ", " + myRs.getInt("scores"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	//method to get the current score in total for a certain player (sum of scores from all played games), if username doesn't exist, score equals 0
	
	public void getPlayerScore(String username)
	{
		int sum = 0;
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("select * from scores where username = '" + username + "'");
			
			//4. Process the result set
			while (myRs.next()) 
			{
				sum = sum + myRs.getInt("scores");
			}
			System.out.println(sum);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	//method to add a new entry for a player with score from played game
	
	public void addScore(String username, String password, int score)
	{
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "root", "");
			
			//2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3. Execute SQL query
			myStmt.executeUpdate("insert into scores (username, password, scores) values ('" + username + "', '" + password + "'," + score + ");");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
