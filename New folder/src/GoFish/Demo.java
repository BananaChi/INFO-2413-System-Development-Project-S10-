/* 
 * @author Ravnit Kaur, @author Kim Tang
 * @version 1.0
 */
package GoFish;

import java.util.Scanner;

public class Demo {
	
	public static int waiting = 0;
	public static boolean register = false;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) { //timed
		Scanner input = new Scanner(System.in);
    	System.out.println("===================================");
        System.out.println("Welcome to Go Fish!");
        System.out.println("===================================\n");
        try {
        
		rules();
				
		 String name1;
	     String name2;
        char mode = selectMode();
      
        if (mode=='1') {
        	char l = displayLoginInfo();
        	if (l=='l' || l=='L') {
        		Timer.End();
        		name1 = login();
         	}
        	else if (l=='g' || l=='G') {
        		Timer.End();
        		name1 = "Guest1";
           	}
        	else {
        		Timer.End();
        		name1 = register();
        	}
        	Game GoFish = new Game(name1);
    		GoFish.playGame();
    		if (l=='l' || l=='L' || l=='r' || l=='R') {
    			System.out.println(name1 + " Do you want to see your previous scores? ");
        		System.out.println("Press Y for YES");
        		System.out.println("Press N for NO");
        		char answer = input.next().charAt(0);
        		if (answer == 'Y'|| answer == 'y') {
        			Driver.getPlayerScore(name1);// Display all scores saved in database for name1 in ascending/descending order
        		}
    		}
    	}
        
        if (mode=='2') {
        	System.out.println("Player1, please pick one of the following options: ");
        	char loginOne = displayLoginInfo();
        	if (loginOne=='l' || loginOne=='L') {
        		Timer.End();
        		System.out.println("Player1, please login:");
        		name1 = login();
        	}
        	else if (loginOne=='g' || loginOne == 'G') {
        		Timer.End();
        		name1 = "Guest1";
           	}
        	else {
        		Timer.End();
        		System.out.println("Player1, please register: ");
        		name1 = register();
        	}
        	System.out.println("Player2, please pick one of the following options: ");
        	char loginTwo = displayLoginInfo();
        	if (loginTwo=='l' || loginTwo=='L') {
        		Timer.End();
        		System.out.println("Player1, please login:");
        		name2 = login();
        	}
        	else if (loginTwo=='g' || loginTwo=='G') {
        		Timer.End();
        		name2 = "Guest2";
           	}
        	else {
        		Timer.End();
        		System.out.println("Player1, please register: ");
        		name2 = register();
        	}
        	
        	Game GoFish = new Game(name1, name2);
    		GoFish.playGame();
    		if (loginOne=='l' || loginOne=='L' || loginOne=='r' || loginOne=='R') {
    			System.out.println(name1 + " Do you want to see your previous scores? ");
        		System.out.println("Press Y for YES");
        		System.out.println("Press N for NO");
        		char answer = input.next().charAt(0);
        		Timer.Start();
        		if (answer == 'Y'|| answer == 'y') 
        		{
        			// Display all scores saved in database for name1 in descending order
        			Driver.getPlayerScore(name1);
        			Timer.End();
        			
        		}
    		}
    		if (loginTwo=='l' || loginTwo=='L' || loginTwo=='r' || loginTwo=='R') {
    			System.out.println(name2 + " Do you want to see your previous scores? ");
        		System.out.println("Press Y for YES");
        		System.out.println("Press N for NO");
        		char answer = input.next().charAt(0);
        		Timer.Start();
        		if (answer == 'Y'|| answer == 'y') {
        			// Display all scores saved in database for name1 in descending order
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
	
	public static char displayLoginInfo() { //timed
		Scanner loginInfo = new Scanner(System.in);
        System.out.println("Press l if you want to login to your account");
        System.out.println("Press g if you want to play as a guest");
        System.out.println("Press r if you are a new user and want to register");
        char l = loginInfo.next().charAt(0);
        Timer.Start();
        if (l == 'l' || l == 'L' || l=='g' || l=='G' || l=='r' || l=='R') {
        	return l;
        }
        else {
        	System.out.println("Invalid input");
        	Timer.End();
        	l = displayLoginInfo();
        }
        return l;
	}
	
	public static String login() { //timed
		System.out.println("Please enter your usernname: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		Timer.Start();
		
		while(Driver.usernameExists(username)==false)
		{
			System.out.println("Username does not exist");
			System.out.println("Please enter your usernname: ");
			Timer.End();
			username = input.nextLine();
			Timer.Start();
		}
		Timer.End();
		//String password = new Demo().passwordExample();
		System.out.println("Please enter your password in the new window: ");
		waiting = 1;
		PasswordDemo.createAndShowGUI(username);
		while (waiting == 1)
		{
			System.out.print("");
		}
		return username;
	}
	
	public static String register() { //timed
		Demo.setRegister();
		System.out.println("Please choose a username: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		Timer.Start();
		String loginname = null;
		
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
	
	public static char rules() { //timed
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
}
