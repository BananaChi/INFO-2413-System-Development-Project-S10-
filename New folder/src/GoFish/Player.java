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
     * @param crazyEight, gives access to the "draw pile".
     * @param prev, the previously played card. 
     * @return a card from the player's hand.
     */
    public abstract Card play(Game crazyEight, Card prev);

    
   
   
    public int score() {
    	
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
     * Card matches: two cards match if their rank is the same. 
	 * @param card1, the card 1
     * @param card2, the card 2
     * @return true, if card1 matches card2
     */
    public static boolean cardMatches(Card card1, Card card2) {
    	return card1.getRank() == card2.getRank();
    		    	
    }
}
