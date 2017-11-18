
/**
 * The class implements player strategy.
 * It can be used to play against computer.
 */
public class Computer extends Player {

	/**
	 * Instantiates a new player.
	 *
	 * @param name, the name of the player.
	 */
	public Computer(String name){
		super(name);
	}
	
    /* This method implements play from Player class  */
    public Card play(Game GoFish, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(GoFish, prev);
        }
        return card;
    }

    /**
     * Searches the player's hand for a matching card.
	 * <p>
	 * returns null if no match found.
	 * </p>
     * @param prev, the previously played card. 
     * @return a card from the player's hand.
     */
    private Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        } 
        return null;
    }

    /**
     * Draw cards from "draw pile" until a match is found.
     *
     * @param GoFish, gives access to the "draw pile".
     * @param prev, the previously played card.
     * @return a card that matches prev.
     */
    private Card drawForMatch(Game GoFish, Card prev) {
        while (true) {
            Card card = GoFish.draw();
            System.out.println("\n*** " + name + " draws " + card + "\n");
            if (cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }


}
