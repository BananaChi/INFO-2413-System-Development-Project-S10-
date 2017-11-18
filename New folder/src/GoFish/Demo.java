import java.util.Scanner;

public class Demo {

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
        
		rules();
				
        System.out.println("Press 1 to play against computer");
        System.out.println("Press 2 to play against another player");
       
        String name1;
        String name2;
        int mode = input.nextInt();
      
        if (mode==1) {
        	int l = displayLoginInfo();
        	if (l==1) {
        		name1 = login();
         	}
        	else if (l==2) {
        		name1 = "Guest1";
           	}
        	else {
        		name1 = register();
        	}
        	Game GoFish = new Game(name1);
    		GoFish.playGame();
    		if (l==1 || l==3) {
    			System.out.println(name1 + " Do you want to see your previous scores? ");
        		System.out.println("Press Y for YES");
        		System.out.println("Press N for NO");
        		char answer = input.next().charAt(0);
        		if (answer == 'Y'|| answer == 'y') {
        			Driver.getPlayerScore(name1);// Display all scores saved in database for name1 in ascending/descending order
        		}
    		}
    	}
        
        if (mode==2) {
        	System.out.println("Player1, please pick one of the following options: ");
        	int loginOne = displayLoginInfo();
        	if (loginOne==1) {
        		System.out.println("Player1, please login:");
        		name1 = login();
        	}
        	else if (loginOne==2) {
        		name1 = "Guest1";
           	}
        	else {
        		System.out.println("Player1, please register: ");
        		name1 = register();
        	}
        	System.out.println("Player2, please pick one of the following options: ");
        	int loginTwo = displayLoginInfo();
        	if (loginTwo==1) {
        		System.out.println("Player1, please login:");
        		name2 = login();
        	}
        	else if (loginTwo==2) {
        		name2 = "Guest2";
           	}
        	else {
        		System.out.println("Player1, please register: ");
        		name2 = register();
        	}
        	
        	Game GoFish = new Game(name1, name2);
    		GoFish.playGame();
    		if (loginOne==1 || loginOne==3) {
    			System.out.println(name1 + " Do you want to see your previous scores? ");
        		System.out.println("Press Y for YES");
        		System.out.println("Press N for NO");
        		char answer = input.next().charAt(0);
        		if (answer == 'Y'|| answer == 'y') 
        		{
        			Driver.getPlayerScore(name1);
        			// Display all scores saved in database for name1 in ascending/descending order
        		}
    		}
    		if (loginTwo==1 || loginTwo==3) {
    			System.out.println(name2 + " Do you want to see your previous scores? ");
        		System.out.println("Press Y for YES");
        		System.out.println("Press N for NO");
        		char answer = input.next().charAt(0);
        		if (answer == 'Y'|| answer == 'y') {
        			Driver.getPlayerScore(name2);
        			// Display all scores saved in database for name2 in ascending/descending order
        		}
    		}
    		
        }
        }
        catch(Exception e){
        	System.out.println(e.toString());
        }
    }
	
	public static int displayLoginInfo() {
		Scanner loginInfo = new Scanner(System.in);
        System.out.println("Press 1 if you want to login to your account");
        System.out.println("Press 2 if you want to play as a guest");
        System.out.println("Press 3 if you are a new user and want to register");
        int l = loginInfo.nextInt();
        return l;
	}
	
	public static String login() {
		System.out.println("Please enter your usernname: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		while(Driver.usernameExists(username)==false)
		{
			System.out.println("Please enter your usernname: ");
			username = input.nextLine();
		}
		System.out.println("Please enter your password: ");
		String password = input.nextLine();
		//String password = new jline.ConsoleReader().readLine(new Character('*'));
		if (Driver.getPlayerPassword(username).equals(password)) {
			System.out.println("You are logged in successfully!");
		}
		else{
			System.out.println("Username or password is incorrect");
			login();
		}
		return username;
	}
	
	public static String register() {
		System.out.println("Please choose a username: ");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine();
		String loginname = null;
		
		if (Driver.usernameExists(username) == true) {
			System.out.println(username + " is not available.");
	 		loginname = register();
		}
		else {
			System.out.println("Please enter a password: ");
		  	String password = input.nextLine();
		  	Driver.addUser(username, password);
		  	System.out.println("You have successfully registered as " + username);
		  	loginname = username;
		}
		 return loginname;
	}
	
	public static char rules() {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you know rules of the game?");
		System.out.println("Press Y for YES");
		System.out.println("Press N for NO");
		char r = input.next().charAt(0);
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
		}
		else if (r == 'Y' || r =='y') {
			return r;
		}
		else {
			System.out.println("Invalid input");
			System.out.println("Please enter \"Y\" for YES or \"N\" for NO");
			r = rules();
		}
		return r;
	}

}
