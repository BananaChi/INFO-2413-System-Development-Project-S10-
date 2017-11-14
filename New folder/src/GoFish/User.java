import java.util.Scanner;

/**
 * This class represents a human player (user) in a game of GoFish.
 */
public class User extends Player {
	/** The input. */
	private Scanner input;
	
	
	//comment 
	/**
	 * Instantiates a human player with an empty hand.
	 *
	 * @param name, the name of the player
	 */
	public User(String name){
		super(name);
		input = new Scanner(System.in);
	}
	
	public Card play(Game GoFish) {
		return null;
	}

	public void saveScore(int scores) {
		
	}
}
