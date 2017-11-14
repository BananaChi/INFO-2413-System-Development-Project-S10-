/**
 * This class represents a hand: the cards held by one player.
 */
public class Hand extends CardArray{
	
	/**
	 * Instantiates a new hand.
	 */
	public Hand() {
		super();
	}
	
    /**
     * Pop card: removes and returns the card in Hand at 
     * the given index.
	 * <p>
	 * Note: this method overloads popCard() in CardArray class.
	 * </p>
     *
     * @param i, the (zero-based) index of a card in Hand.
     * @return the card
     */
    public Card popCard(int i) {
    	Card card = cards.remove(i);
    	return card;
    }
	
    /**
     * Gets the card: returns (but does not remove) the card 
     * in Hand at the given index.
     *
     * @param i, the (zero-based) index of a card in Hand.
     * @return the card
     */
    public Card getCard(int i) {    	
    	return cards.get(i);
    }

    /* Returns a string representation of the Hand. */
    @Override
    public String toString() {
    	if(cards.isEmpty())
    		return "empty!";
    	
    	String output = "";
    	for(int i=0; i<cards.size(); i++){
    		output += "[" + Integer.toString(i+1) + "]: " + cards.get(i) + "\n";
    	}
    	return output;
    }
}
