/* 
 * @author Ravnit Kaur, @author Kim Tang
 * @version 1.0
 */

package GoFish;

import java.util.Scanner;

/**
 * This class represents a human player (user) in a game of Go Fish.
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
    	
    	//loop variable resets timer accordingly if a new card is drawn 
    	//(otherwise the moment from drawing the first card until for example the end of drawing 6 more cards
    	//before playing the 7th card would be timed and that's inaccurate
    	
    	//initially it will be assumed that we are not in the loop
    	//loop = 1 means in the loop
    	//loop = 0 means out of the loop, where loop means we draw more cards with 0 (go fish)
    	
    	int loop = 1;
    	   	
    	// Get the card number from the user
    	int n = promptUser();
    	Timer.Start();
    	
    	//set loop variable to 0 because we are in the loop
    	if (n==0)
    	{
    		//Timer.Start();
    		loop=0;
    	}
    	    	    	    	   	
    	Card card;
    	
    	// When the user wants to draw a new card from draw Pile
    	while (n == 0){
    		card = GoFish.draw();
    		System.out.println("\n*** " + name + " draws " + card + "\n");
    		hand.addCard(card);
    		System.out.println(name + "'s hand:");
    		System.out.println(hand);
    		
    		//if we were in the loop, meaning we drew a card, the timer will be stopped and we are out of the loop
    		if (loop==0)
    		{
    			//Timer ended.
    			Timer.End();
    			loop=1;
    		}
    		System.out.print("Select a card from your hand \n   or enter 0 to go fish! (draw a new card): ");
    	    n = input.nextInt();
    	    //Timer started.
	    	Timer.Start();
	    	//if the next action is drawing a card again (input = 0 for go fish) we are in the loop again
    	    if (n==0)
    	    {
    	    	
    	    	loop=0;
    	    }
    	}
    		
    	card = hand.getCard(n-1);
    	
    	// When the card chosen by player matches the previous card
    	if(Player.cardMatches(card, prev))
    	{
    		//System.out.println("This is madness");
    		Timer.End();
    	    return hand.popCard(n-1);
    	}
    	
    	// When the card chosen by player doesn't match the previous card
    	else{
    		while(Player.cardMatches(card, prev) == false){
            	System.out.println();
        		System.out.print("This card is a mismatch." + 
            		" \nSelect a matching card from your hand\n   "
        					+ "or enter 0 to go fish! (draw a new card): ");
           		n = input.nextInt();
           		
           		//same loop procedure as above
           		if (n==0) {
           			loop=0;
           		}           		
           		Timer.Start();
           		
        		if (n > 0) {
        			// Get the card from hand
        			card = hand.getCard(n-1);
        			Timer.End();
        		}   
        		else {
        		    while (n == 0){
        		    	card = GoFish.draw();
        		    	if (loop==0) {
        		    		Timer.End();
        		    		loop=1;
        		    	}
        		    	System.out.println("\n*** " + name + " draws " + card + "\n");
        		    	hand.addCard(card);
        		   		System.out.println(name + "'s hand:");
        		   		System.out.println(hand);
        		   		System.out.print("Select a card from your hand \n   or enter 0 to go fish! (draw a new card): ");
        		   	    n = input.nextInt();
        		   	    if (n==0) {
        		   	    	Timer.Start();
        		   	    	loop=0;
        		   	    }
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
    	String in = input.nextLine();
    	int n;
    	Timer.Start();
    	// When user enters a digit
    	if (in.matches("\\d+")) {
    		n = Integer.parseInt(in);
    	 	// When user enters larger value than hand size or a negative value
    		if (n > hand.size() || n < 0) {
    			Timer.End();
    			System.out.println("Invalid input! Card does not exist");
    			n = promptUser();
    		}
    	}
    	// When user does not enter a digit
    	else {
    		System.out.println("Invalid input!");
    		n = promptUser();
    	}
    	Timer.End();
    	return n;
    }
}
