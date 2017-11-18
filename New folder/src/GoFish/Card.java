/* 
 * @author Ravnit Kaur
 * @version 1.0
 */
package GoFish;

/**
 * This class represents a standard playing card.
 */
public class Card {
	
	/**  A suit symbol on a card. */
    private final int suit; 
    
    /** The position of a card relative to others in the same suit. */
    private final int rank; 
    
    /**  The Constant array of RANKS. */
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    /** The Constant array of SUITS. */
    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};
    
    
    /**
     * Instantiates a new card.
     *
     * @param rank, the rank
     * @param suit, the suit
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Gets the rank.
     *
     * @return the rank
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Gets the suit.
     *
     * @return the suit
     */
    public int getSuit() {
        return this.suit;
    }
    
    /**
     * Compare to.
     *
     * @param that the that
     * @return -1, if this card comes before the given card; 
     * 0, if the two cards are equal;
     * 1, if this card comes after the card.
     */
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    /**
     * Equals.
     *
     * @param that, object of a Card
     * @return true, if the given card has the same
     * rank AND same suit; otherwise returns false.
     */
    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }
    
    /* Returns a string representation of the card.  */
    @Override
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

}