/**
 * 
 */
import java.util.Scanner;
/**
 * The class creates and maintains the state of the GoFish game.
 */
public class Game {
	/** The player 1. */
	private Player player1;
	
	/** The player 2. */
	private Player player2;
	
	/** The draw pile (Stock). */
	private Pile drawPile;
	
	/** The input. */
	private Scanner input;
	 
	/**
     * Instantiates a new game.
	 * Note: this constructor creates two human players.
     */
    public Game(String name1, String name2) { 
        player2 = new User(name 1);
        player1 = new User(name 2); 
        input = new Scanner(System.in);
        initializeGame();
    }
	
	/**
     * Instantiates a new game.
	 * Note: this constructor creates one computer players.
	 * and one human player (user). 
	 * This is useful for a 1-player game.
     * @param name, the name of the human player (user)
     */
    public Game(String name){
    	player1 = new User(name);
    	player2 = new Computer("Computer");
    	input = new Scanner(System.in);
    	initializeGame();
    }
    
	/**
     * Initializes the state of the game.
     */
    private void initializeGame() {
        // Create and shuffle a pack (full deck)
        Deck pack = new Deck();
        pack.shuffle();
        
        // Deal cards to each player
        int handSize = 5;
        pack.deal(player1.getHand(), handSize);
        pack.deal(player2.getHand(), handSize);

        
        // put the rest of the deck face down
        drawPile = new Pile("Draw pile");
        pack.dealAll(drawPile);
    }
    
    /**
     * Draw: deal one card face up from draw pile.  
     * <p>
	 * Note: If the draw pile ever runs out, game is over
	 * </p>
     * @return a card from the draw pile.
     */
    /*  */
    public Card draw() {
        if (drawPile.empty()) {
            // end the game
        }
        return drawPile.popCard();
    }
    
    /**
     * Switches players.
     *
     * @param current, the current player
     * @return the next player
     */
    private Player nextPlayer(Player current) {
        if (current == player1) {
            return player2;
        } else {
            return player1;
        }
    }
    
    /**
    * Displays the state of the game. 
    */
   private void displayState() {
       player1.display();
       player2.display();
       // TODO
   }
   
   /**
    * Player takes a turn.
    *
    * @param player, the player who should play now.
    */
   private void takeTurn(Player player) {
       System.out.println("-----------------------------------");
       System.out.println("\t" + player.getName() + "'s turn!");
       System.out.println("-----------------------------------");
       // TODO

   }
   
   /**
    * Play the game.
    */
   public void playGame() {
	   Player player = player1;

       // keep playing until there's a winner
       while (!isDone()) {
           displayState(); 
           takeTurn(player);
           player = nextPlayer(player);
           waitForUser();
       }
       
       // display the final score
       player1.displayScore();
       player2.displayScore();
    
       // display the winner
       if(player1.score()<player2.score())
       	System.out.println(player2.username + " wins!");
       else if (player1.score()==player2.score())
       	System.out.println("It is a draw!");
       else
       	System.out.println(player1.username + " wins!");
   }
   
   /**
    * Checks if game is done.
    *
    * @return true,  if either player's hand is empty. 
    */
   private boolean isDone() {
       return player1.getHand().empty() || player2.getHand().empty();
   }
   
   /**
    * Waits for the user to press enter.
    */
   private void waitForUser() {
   	System.out.println(">>> Press Enter to continue! >>>\n");
       input.nextLine();
   }
}
