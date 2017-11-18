/* 
 * @author Ravnit Kaur (100329274) 
 * @version 1.0
 */
package GoFish;
import java.util.ArrayList;

/**
 * This abstract class encapsulates 
 * an array of playing cards. 
 */

public abstract class CardArray 
{
	
	/** The cards. */
    protected ArrayList<Card> cards;

    /**
     *  Constructs an empty ArrayList of type Card. 
     */
    public CardArray() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * Adds the card to ArrayList cards.
     *
     * @param card, the card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Pop card: remove and return the last card 
     * in ArrayList cards. 
     *
     * @return the last card in ArrayList cards
     */
    public Card popCard() {
    	Card card = cards.remove(size()-1);
    	return card;
    }

    /**
     * Size.
     *
     * @return the number of cards in the ArrayList cards.
     */
    public int size() {
        return cards.size();
    }

    /**
     * Empty.
     *
     * @return true, if the ArrayList cards is empty;
     * false, otherwise. 
     */
    public boolean empty() {
        return cards.size() == 0;
    }
    
}
