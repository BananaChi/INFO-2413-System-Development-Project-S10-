/* 
 * @author Ravnit Kaur, @author Kim Tang
 * @version 1.0
 */
package GoFish;

import java.util.Scanner;

/* 
 * This class gives the demo of the game.
 * This class needs to be run to play the game
 */
public class Demo {
	
	public static int waiting = 0;
	public static boolean register = false;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	System.out.println("===================================");
        System.out.println("Welcome to Go Fish!");
        System.out.println("===================================\n");
        try {
        	// Ask user to show rules of the game
        	rules();
        	
			//names of players to display in the game	
        	String name1;
        	String name2;
        	
        	//Select single-player or two players game
        	char mode = selectMode();
        	
        	// Single-payer game
        	
        	//Play by log in
        	if (mode=='1') {
        		char l = displayLoginInfo();
        		if (l=='l' || l=='L') {
        			// Timer to notice the time consumed by the system/game
        			Timer.End();
        			//Get player's name
        			name1 = login();
         	}
        		
        	//Play as a guest
        	else if (l=='g' || l=='G') {
        		Timer.End();
        		name1 = "Guest1";
           	}
        		
        	// New player and wants to register
        	else {
        		Timer.End();
        		name1 = register();
        	}
        		
        	//Start playing the game one human player and a computer
        	Game GoFish = new Game(name1);
    		GoFish.playGame();
    		
    		// If a user is logged in or newly registered, display previous scores
    		if (l=='l' || l=='L' || l=='r' || l=='R') {
    			System.out.print(name1+ ", ");
        		char answer = displayScores();
        		if (answer == 'Y'|| answer == 'y') {
        			// Display all scores saved in database for name1 in descending order
        			Driver.getPlayerScore(name1);
        		}
    		}
    	}
        
        
        // Two-player game
        if (mode=='2') {
        	// Prompt player1 to log in, play as guest, or register
        	System.out.println("Player1, please pick one of the following options: ");
        	char loginOne = displayLoginInfo();
        	
        	// Player1 logs in
        	if (loginOne=='l' || loginOne=='L') {
        		// Timer to notice the time consumed by the system/game
        		Timer.End();
        		System.out.println("Player1, please login:");
        		name1 = login();
        	}
        	
        	// Player1 chooses to play as a guest
        	else if (loginOne=='g' || loginOne == 'G') {
        		Timer.End();
        		name1 = "Guest1";
           	}
        	
        	// Player1 chooses to register
        	else {
        		Timer.End();
        		System.out.println("Player1, please register: ");
        		name1 = register();
        	}
        	
        	// Prompt player2 to log in, play as guest, or register
        	System.out.println("Player2, please pick one of the following options: ");
        	char loginTwo = displayLoginInfo();
        	
        	// Player2 logs in
        	if (loginTwo=='l' || loginTwo=='L') {
        		// Timer to notice the time consumed by the system/game
        		Timer.End();
        		System.out.println("Player2, please login:");
        		name2 = login();
        	}
        	
        	// Player2 chooses to play as a guest
        	else if (loginTwo=='g' || loginTwo=='G') {
        		Timer.End();
        		name2 = "Guest2";
           	}
        	
        	// Player2 chooses to register
        	else {
        		Timer.End();
        		System.out.println("Player1, please register: ");
        		name2 = register();
        	}
        	
        	//Start playing the game with two human players
        	Game GoFish = new Game(name1, name2);
    		GoFish.playGame();
    		
    		// If player1 is logged in or newly registered, display previous scores
    		if (loginOne=='l' || loginOne=='L' || loginOne=='r' || loginOne=='R') {
    			System.out.print(name1+ ", ");
        		char answer = displayScores();
        		Timer.Start();
        		if (answer == 'Y'|| answer == 'y') 
        		{
        			// Display all scores saved in database for name1 in descending order
        			Driver.getPlayerScore(name1);
        			Timer.End();
        			
        		}
    		}
    		
    		// If player2 is logged in or newly registered, display previous scores
    		if (loginTwo=='l' || loginTwo=='L' || loginTwo=='r' || loginTwo=='R') {
    			System.out.print(name2+ ", ");
        		char answer = displayScores();
        		Timer.Start();
        		if (answer == 'Y'|| answer == 'y') {
        			// Display all scores saved in database for name2 in descending order
        			Driver.getPlayerScore(name2);
        			Timer.End();
        		}
    		}
    		
        }
      }
      catch(Exception e){
       	System.out.println(e.toString());
      }
    }
	
	/* A method to display login information for a player*/
	public static char displayLoginInfo() {
		Scanner loginInfo = new Scanner(System.in);
        System.out.println("Press l if you want to login to your account");
        System.out.println("Press g if you want to play as a guest");
        System.out.println("Press r if you are a new user and want to register");
        char l = loginInfo.next().charAt(0);
        // Timer to notice the time consumed by the system/game
        Timer.Start();
        if (l == 'l' || l == 'L' || l=='g' || l=='G' || l=='r' || l=='R') {
        	return l;
        }
        
        // If a user enters invalid input
        else {
        	System.out.println("Invalid input");
        	// Timer to notice the time consumed by the system/game
        	Timer.End();
        	l = displayLoginInfo();
        }
        return l;
	}
	
	/* A method to get the user logged in*/
	public static String login() {
		System.out.println("Please enter your usernname: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		Timer.Start();
		// If username does not exist
		while(Driver.usernameExists(username)==false)
		{
			System.out.println("Username does not exist");
			System.out.println("Please enter your usernname: ");
			Timer.End();
			username = input.nextLine();
			Timer.Start();
		}
		Timer.End();
		// Enter user's password in new window
		System.out.println("Please enter your password in the new window: ");
		waiting = 1;
		PasswordDemo.createAndShowGUI(username);
		while (waiting == 1)
		{
			System.out.print("");
		}
		return username;
	}
	
	/* A method to get a new user registered*/
	public static String register() {
		Demo.setRegister();
		System.out.println("Please choose a username: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		Timer.Start();
		String loginname = null;
		
		// If user name already exists in the database
		if (Driver.usernameExists(username) == true) {
			System.out.println(username + " is not available.");
			Timer.End();
	 		loginname = register();
		}
		
		else {
			Timer.End();
			System.out.println("Please enter a password: ");
			waiting = 1;
			PasswordDemo.createAndShowGUI(username);
			while (waiting == 1)
			{
				System.out.print("");
			}
			String password = PasswordDemo.getPassword();
		  	Driver.addUser(username, password);
		  	System.out.println("You have successfully registered as " + username);
		  	Timer.End();
		  	loginname = username;
		}
		 return loginname;
	}
	
	public static int getWaiting()
	{
		return waiting;
	}
	
	public static void setWaiting(int n)
	{
		waiting=n;
	}
	
	public static boolean getRegister()
	{
		return register;
	}
	
	public static void setRegister()
	{
		register = true;
	}
	
	/*A method to show rules of the game */
	public static char rules() {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you know rules of the game?");
		System.out.println("Press Y for YES");
		System.out.println("Press N for NO");
		char r = input.next().charAt(0);
		Timer.Start();
		if (r == 'n'|| r == 'N') {
			System.out.println("Rules of game:\n" + 
					"1. Each player will get 5 cards.\n" + 
					"2. Rest of the cards in deck will stay in a pile (facing down)\n" + 
					"3. One card from the pile (pile in step2) will be turned up.\n" + 
					"4. Player1 will have to find a matching card (from his hand) with the card in step3.\n" + 
					"   Here matching card means, a card with either the same rank or the same suit.\n" + 
					"For example: If there is an ace of spade, you need to look either for an ace or any card of spade. \n" +
					"5. If he/she finds a match, he/she will throw the matching card in discard pile (another pile).\n" + 
					"6. If he/she does not have a matching card, he/she will \"Go Fish\", means he will keep on drawing cards from pile(pile in step 2) until he finds a match.\r\n" + 
					"7. When he throws a matching card, second player has to find a card, matching with the card thrown by player 1.\r\n" + 
					"\r\n" + 
					"How will game get over and how are scores calculated?\r\n" + 
					"1. If either player runs out of cards, game is over.\r\n" + 
					"2. The player who is left with the cards will get negative points.\r\n" + 
					"3. For each left over card with a rank (Ace to 10), he/she will get minus points of that rank. For example, if he/she has a card with rank 5, he will get -5\r\n" + 
					"4. For each left over face card (Jack, Queen, King), he/she will get -10 points.\r\n" + 
					"\r\n" + 
					"");
			System.out.println("===================================\n");
			Timer.End();
		}
		else if (r == 'Y' || r =='y') {
			Timer.End();
			return r;
		}
		else {
			System.out.println("Invalid input");
			System.out.println("Please enter \"Y\" for YES or \"N\" for NO");
			Timer.End();
			r = rules();
		}
		return r;
	}

	/* A method to prompt user to choose single-player or two-payers game*/
	public static char selectMode() { //timed
		Scanner input = new Scanner(System.in);
		System.out.println("Press 1 to play against computer");
        System.out.println("Press 2 to play against another player");
		char mode = input.next().charAt(0);
		Timer.Start();
		if (mode == '1' || mode == '2') {
			Timer.End();
			return mode;
		}
		else {
			System.out.println("Invalid input");
			Timer.End();
			mode = selectMode();
		}
		Timer.End();
		return mode;
	}
	
	/*A method to prompt user to display previous scores */
	public static char displayScores() {
		Scanner input = new Scanner(System.in);
		System.out.println(" Do you want to see your previous scores? ");
		System.out.println("Press Y for YES");
		System.out.println("Press N for NO");		
		char answer = input.next().charAt(0);
		if (answer == 'Y'|| answer == 'y' ) {
			return answer;
		}
		else if (answer == 'N' || answer == 'n') {
			return answer;
		}
		else {
			System.out.println("Invalid input");
			answer = displayScores();
		}
		return answer;
	}
}
