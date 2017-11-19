package TestGoFish;
import java.util.Scanner;
import java.io.InputStream;


import java.io.Console;
import java.io.IOException;


public class Demo {
	
	public static int waiting = 0;
	public static boolean register = false;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		
    	System.out.println("===================================");
        System.out.println("Welcome to Go Fish!");
        System.out.println("===================================\n");
        System.out.println("Press 1 to play against computer");
        System.out.println("Press 2 to play against another player");
        Scanner input = new Scanner(System.in);
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
		//String password = new Demo().passwordExample();
		System.out.println("Please enter your password in the new window: ");
		waiting = 1;
		PasswordDemo.createAndShowGUI(username);
		//String password = input.nextLine();
		//java.io.Console console = System.console();
        //String password = new String(console.readPassword("Password: "));
		//String password = readPwd();
		//System.out.println("You are logged in successfully!"); //can be removed
		
		
		/*if (Driver.getPlayerPassword(username).equals(password)) {
			System.out.println("You are logged in successfully!");
		}
		else{
			System.out.println("Username or password is incorrect");
			login();
		}*/
		while (waiting == 1)
		{
			System.out.print("");
		}
		return username;
	}
	
	public static String register() {
		Demo.setRegister();
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
		  	//String password = input.nextLine();
		  	//TODO
			waiting = 1;
			PasswordDemo.createAndShowGUI(username);
			while (waiting == 1)
			{
				System.out.print("");
			}
			String password = PasswordDemo.getPassword();
		  	Driver.addUser(username, password);
		  	System.out.println("You have successfully registered as " + username);
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
	
	
	
	
}
