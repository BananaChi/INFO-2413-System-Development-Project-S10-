import java.util.Scanner;
public class Demo {

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
        Scanner mode = new Scanner(System.in);
        String name1;
        String name2;
        int m = mode.nextInt();
        
        if (m==1) {
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
        }
        
        if (m==2) {
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
		Scanner name = new Scanner(System.in);
		String username = name.nextLine();
		System.out.println("Please enter your password: ");
		Scanner pwd = new Scanner(System.in);
		String password = pwd.nextLine();
		/*if (username && password exist in database){
				System.out.println("You are logged in successfully!");
		}
		else{
			System.out.println("Username or password is incorrect")
			login();
		}
		*/
		return username;
	}
	
	public static String register() {
		System.out.println("Please choose a username: ");
		Scanner name = new Scanner(System.in);
		String username = name.nextLine();
		Scanner pwd = new Scanner(System.in);
		/* if (username already exists in database){
		 		System.out.println(username + " is not available.");
		 		register();
		  }
		  else {
		  	System.out.println("Please enter a password: ");
		  	String password = pwd.nextLine();
		  	//Save username and password in database; 
		  	System.out.println("You have successfully registered as " + username);
		  }
		*/
		 return username;
	}

}
