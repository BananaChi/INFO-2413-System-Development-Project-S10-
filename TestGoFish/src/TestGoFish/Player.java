package TestGoFish;

import TestGoFish.Card;
import TestGoFish.Hand;

/* 
 * @author Ravnit Kaur (100329274)  
 * @version 1.0
 */

/**
 * This class encapsulates a player in a game of crazy eights.
 */
public abstract class Player {

    /** The name of the player */
    protected String name;
    
    /** The hand: the cards held by one player. */
    protected Hand hand;
    
    /**
     * Instantiates a new player with an empty hand.
     *
     * @param name, the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Gets the name.
     *
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the hand.
     *
     * @return the player's hand. */
    public Hand getHand() {
        return hand;
    }

    /**
     * Play: this is an abstract method and must be 
     * implemented in any derived class.
     *
     * @param GoFish, gives access to the "draw pile".
     * @param prev, the previously played card. 
     * @return a card from the player's hand.
     */
    public abstract Card play(Game GoFish, Card prev);

    
    /**
     * Score: calculates the player's score (penalty points).
	 * <p>
	 * Note: as soon as a player has no cards, the game ends and 
	 * all other players score penalty points for their remaining cards. 
	 * Eights are worth 20, face cards are worth 10, and all others 
	 * are worth their rank.
	 * </p>
     * @return the score
     */
    public int score() {
    	int score = 0;
    	for(int i = 0; i < hand.cards.size(); i++){
    		Card card = hand.getCard(i);
    		if (card.getRank() >= 1 && card.getRank() <= 10)
    			score -= card.getRank();
    		if (card.getRank() >= 11 && card.getRank() <= 13)
    			score -= 10;
    	} 
    	return score;
    }

    /**
     * Display the cards in player's hand.
     */
    public void display() {
    	System.out.println(name + "'s hand:");
        System.out.println(hand);
    }

    /**
     * Display the player's name and score.
     */
    public void displayScore() {
        System.out.println(name + " has " + score() + " points");
    }
    
    /**
     * Save scores of players, except guest players
     */
    public void saveScore() {
    	int scoreValue = score();
    	
    	if(name != "Guest1" && name != "Guest2") 
    	{
    		String pw = Driver.getPlayerPassword(name);
    		Driver.addScore(name, pw, scoreValue);// add scores to database for name
    	}
    }

    /**
     * Card matches: two cards match if their rank or suit is the same. 
     * @param card1, the card 1
     * @param card2, the card 2
     * @return true, if card1 matches card2
     */
    public static boolean cardMatches(Card card1, Card card2) {
    	return card1.getRank() == card2.getRank() ||
    	card1.getSuit() == card2.getSuit();
    		   	
    }
}


