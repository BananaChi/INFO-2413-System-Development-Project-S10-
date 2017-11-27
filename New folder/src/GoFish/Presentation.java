/* 
 * @author Ravnit Kaur
 * @version 1.0
 */
package GoFish;

/**
 * The Presentation: Run this to see two player (computer) play GoFish.
 * This class can be useful for presentation in class
 */
public class Presentation {
	public static void main(String[] args) {		
    	     
        try{
        	Game GoFish = new Game();
        	GoFish.playGame();
        }
        catch(Exception e){
        	System.out.println(e.toString());
        }
	}
}
