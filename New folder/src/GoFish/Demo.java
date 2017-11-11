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
        int l = displayLoginInfo();
        if (m==1) {
        	if (l==1) {
        		//login
        	}
        	else if (l==2) {
        		name1 = "Guest1";
        		Game GoFish = new Game(name1);
        		GoFish.playGame();
        	}
        	else {
        		// register
        	}
        }
        
        if (m==2) {
        	if (l==1) {
        		//login
        	}
        	else if (l==2) {
        		name1 = "Guest1";
        		name2 = "Guest2";
        		Game GoFish = new Game(name1, name2);
        		GoFish.playGame();
        	}
        	else {
        		// register
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

}
