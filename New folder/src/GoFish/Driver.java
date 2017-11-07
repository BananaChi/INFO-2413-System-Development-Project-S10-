package GoFish;

import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		
		try {
			//1. Get a connection to database with root user and blank password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofish", "kim", "kim");
			
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

}
