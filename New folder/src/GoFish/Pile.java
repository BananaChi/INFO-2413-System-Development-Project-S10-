<<<<<<< HEAD
package GoFish;
=======
/* 
 * @author Ravnit Kaur
 * @version 1.0
 */
>>>>>>> ravnit
import java.util.ArrayList;

/**
 * This class represents a pile: a deck of cards that acts 
 * as either Waste or Stock
 * 
 * Stock: a pile of cards, face down, to create a draw pile.
 * Waste: a pile of discarded cards.
 */
public class Pile extends Deck {
	
	/** The label. */
	private String label;
	
	/**
	 * Instantiates a new and empty pile!
	 *
	 * @param label, the label
	 */
	public Pile(String label){
		this.cards = new ArrayList<Card>();
		this.label = label;
	}

    /**
     * Last: Returns (but not remove) the last card.
     *
     * @return the last card in the pile.
     */
    public Card last() {
    	return cards.get(cards.size()-1);
    }
    

    /* Returns a string representation of the Pile. 
     * Print in reverse order: last card is displayed first. 
     */
    @Override
    public String toString() {
    	if(cards.isEmpty())
    		return label + " is empty.";
    	
    	String output = label + ": [";
    	for(int i=cards.size()-1; i>0; i--){
    		output += cards.get(i).toString() + ", ";
    	}
    	output += cards.get(0).toString() + "]";
    	return output;
    }
}
