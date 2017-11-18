<<<<<<< HEAD
package GoFish;
=======
/* 
 * @author Ravnit Kaur
 * @version 1.0
 */
>>>>>>> ravnit
import java.util.Scanner;

/**
 * This class represents a human player (user) in a game of crazy eights.
 */
public class User extends Player {
	
	/** The input. */
	private Scanner input;
	
	/**
	 * Instantiates a human player with an empty hand.
	 *
	 * @param name, the name of the player
	 */
	public User(String name){
		super(name);
		input = new Scanner(System.in);
	}

	/* This method implements play from Player class  */
    public Card play(Game GoFish, Card prev) {
    	   	
    	// Get the card number from the user
    	int n = promptUser();
    	    	   	
    	Card card;
    	
    	// When the user wants to draw a new card from draw Pile
    	while (n == 0){
    		card = GoFish.draw();
    		System.out.println("\n*** " + name + " draws " + card + "\n");
    		hand.addCard(card);
    		System.out.println(name + "'s hand:");
    		System.out.println(hand);
    		System.out.print("Select a card from your hand \n   or enter 0 to go fish! (draw a new card): ");
    	    n = input.nextInt();
    	}
    		
    	card = hand.getCard(n-1);
    	
    	// When the card chosen by player matches the previous card
    	if(Player.cardMatches(card, prev))
    	    return hand.popCard(n-1);
    	
    	// When the card chosen by player doesn't match the previous card
    	else{
    		while(Player.cardMatches(card, prev) == false){
            	System.out.println();
        		System.out.print("This card is a mismatch." + 
            		" \nSelect a matching card from your hand\n   "
        					+ "or enter 0 to go fish! (draw a new card): ");
           		n = input.nextInt();
        		if (n > 0)
        			card = hand.getCard(n-1);
        		else{
        		    while (n == 0){
        		    	card = GoFish.draw();
        		    	System.out.println("\n*** " + name + " draws " + card + "\n");
        		    	hand.addCard(card);
        		   		System.out.println(name + "'s hand:");
        		   		System.out.println(hand);
        		   		System.out.print("Select a card from your hand \n   or enter 0 to go fish! (draw a new card): ");
        		   	    n = input.nextInt();
        		    	}
        			}
			}
    	    return card;
    	}
    }  
    
    public int promptUser() {
    	// Prompt the user
    	System.out.print("Select a card from your hand \n   or enter 0 to go fish! (draw a new card): ");
    	
    	// Get the card number from the user
    	int n = input.nextInt();
    	
    	if (n > hand.size()) {
    		System.out.println("Invalid input! Card does not exist");
    		n = promptUser();
    	}
    	return n;
    }
}
