/* 
 * @author Ravnit Kaur
 * @version 1.0
 */

package GoFish;

import java.util.Random;
import java.util.Scanner;

/**
 * Test code for Card, Deck, Hand, and Pile.
 */
public class UnitTests {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		// Create a Card 
		System.out.println("Create a card ...");
		Random rnd = new Random();
		Card card = new Card(rnd.nextInt(12)+1, rnd.nextInt(4));
		System.out.println(card);
		
		// Create a Deck
		System.out.println("\nCreate a deck ...");
		// Deck deck = new Deck();
		Deck deck = new Deck();
		System.out.println(deck);
		
		// Shuffle the deck
		System.out.println("\nShuffle the deck ...");
		deck.shuffle();
		System.out.println(deck);
		
		// Create a Pile and a Hand
		System.out.println("\nCreate a Pile and a Hand ...");
		Pile pile = new Pile("TestPile");
		Hand hand = new Hand();
		System.out.println(pile);
		System.out.println("TestHand: " + hand);
		
		// Deal cards from the deck
		System.out.println("\nDeal 5 cards from deck to hand a put the remaining into pile...");
		deck.deal(hand, 5); // 5 cards for hand
		deck.dealAll(pile); // all the remaining cards go to pile
		System.out.println(pile);
		System.out.println("TestHand: \n" + hand);
		
		// Pop a card from Pile and add it to the Hand
		System.out.println("\nRemoving the last card from pile: " + pile.last());
		System.out.println("* The last card must appear at the front of the list above");
		Card newCard = pile.popCard();
		System.out.println("Adding it to the hand: ");
		hand.addCard(newCard);
		System.out.println("TestHand: \n" + hand);
		
		// Remove a card from hand
		System.out.print("\nSelect a card from hand to be removed: ");
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		System.out.println("You selected: " + hand.getCard(index-1));
		hand.popCard(index-1);
		System.out.println("TestHand: \n" + hand);
		input.close();
		
		System.out.println("\nAll tests completed!");
	}

}