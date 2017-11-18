<<<<<<< HEAD
package GoFish;
=======
/* 
 * @author Ravnit Kaur
 * @version 1.0
 */
>>>>>>> ravnit
import java.util.Collections;

/**
 * This class represents a standard deck (52 playing cards)
 */
public class Deck extends CardArray {
	
	/**
	 * Instantiates a new deck.
	 */
	public Deck() {
		super();
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards.add(new Card(rank, suit));
			}
		}
	}
	
    /**
     * Shuffle: randomly permute the cards. 
     */
    public void shuffle() {
    	Collections.shuffle(cards);
    }
	
	/**
	 * Deal: To distribute cards to players
	 *
	 * @param hand, the cards held by one player
	 * @param n, number of cards to move from deck to the given hand.
	 */
    public void deal(CardArray hand, int n) {
    	for (int i = 0; i < n; i++){
    		Card card = popCard();
    		hand.addCard(card);
    		
    	}
    }

    /**
     * Deal all: turning over all the cards remaining in deck to pile
     *
     * @param pile, a set of cards that acts as Waste or Stock. 
     */
    public void dealAll(CardArray pile) {
        int n = size();
        deal(pile, n);
    }
	

    /* Returns a string representation of the Deck.  */
    @Override
    public String toString() {
        return "Deck: " + cards.toString();
    }
}
