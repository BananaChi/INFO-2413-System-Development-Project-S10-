import java.util.Scanner;
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
    public Card play(Game GoFish) {
        Card card1 = hand.getCard(0);
        Card card2 = searchForMatch (card1);
        if (card2 == null) {
        	System.out.println("I need" + card1);
        	card2 = anotherPlayerResponse();
        	if (card2 == null) {
        		card2 = drawForMatch(GoFish, card1);
        	}
        	
        }
        return card2;
    }

    /**
     * Searches the player's hand for a matching card.
	 * <p>
	 * returns null if no match found.
	 * </p>
     * @param prev, the card asked by another player. 
     * @return a card from the player's hand.
     */
    private Card searchForMatch(Card prev) {
        for (int i = 1; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        } 
        return null;
    }
    
    private Card anotherPlayerResponse() {
    	Card card;
    	System.out.println("Please enter the number of the card that you want to give");
    	System.out.println("If you do not have the asked card, please enter 0");
    	Scanner input = new Scanner(System.in);
    	int i = input.nextInt();
    	if (i == 0) {
    		card = null;
    		System.out.println("GoFish");
    	}
    	else{
    		card = hand.popCard(i);
    	}
    	return card;
    }

    /**
     * @param GoFish, gives access to the "draw pile".
     * @param prev, card chosen from hand.
     * @return a card that matches prev.
     */
    private Card drawForMatch(Game GoFish, Card prev) {
        Card card = GoFish.draw();
        if (cardMatches(card, prev)) {
        	return card;
        }
        hand.addCard(card);
        return null;
    }


}
