/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Khang Bui
 * @author Tin Nguyen
 */
public class Game {

    private final String name = "Black Jack"; // Name of the game.
    private String playerName; // Name of the player.
    private Player player; // Player object.
    private int startingChips; // Starting number of chips for the player.
    private Dealer dealer; // Dealer object.
    private Deck deck; // Deck of cards.
    private int betAmount; // Amount of bet for each round.
    
    Scanner scanner = new Scanner(System.in); // Scanner object for user input.

    // Constructor to create a new game instance.
    public Game(String playername,int startingChips) {
        this.startingChips = startingChips; // Set starting chips.
        this.player = new Player(playerName,startingChips); // Create player object.
        this.dealer = new Dealer(); // Create dealer object.
        this.playerName = playername; // Set player name.
    }

    // Method to retrieve the dealer object.
    public Dealer getDealer() {
        return this.dealer;
    }

    // Method to retrieve the player object.
    public Player getPlayer(){
        return this.player;
    }

    // Method to retrieve the name of the game.
    public String getName() {
        return this.name;
    }

    // Method to start a new round of the game.
    public void startNewRound(){
        player.resetHand(); // Reset player's hand.
        dealer.resetHand(); // Reset dealer's hand.
        this.deck =new Deck(); // Create new deck.
        deck.shuffle(); // Shuffle the deck.
        System.out.println("How much do you want to bet "); // Prompt for bet amount.
        betAmount= scanner.nextInt(); // Read bet amount from user input.
        
        //  Give each player a hand
        player.drawCard(deck.drawCard());
        dealer.drawCard(deck.drawCard());
        player.drawCard(deck.drawCard());
        dealer.drawCard(deck.drawCard());

        // Player's turn
        dealer.displayHand(); // Display dealer's hand.
        System.out.println(" ");
        System.out.println(player.toString()); // Display player's hand.
        while (player.getScore() < 21) {
            System.out.println("HIT OR STAND(type 1 for hit  and type 2 for stand):"); // Prompt for player action.
            int choice = scanner.nextInt(); // Read player's choice.
            if (choice == 1){
                player.drawCard(deck.drawCard()); // Player hits.
                System.out.println(player.toString()); // Display updated hand.
            } 
            else if(choice ==2){
                break; // Player stands.
            }
        }
        // Dealer's turn.
        dealer.toString(); // Display dealer's hand.
        while (dealer.getScore() < 17) {
            dealer.drawCard(deck.drawCard()); // Dealer hits until score is 17 or higher.
        }
        if (player.getScore() > 21) {
            player.loseChips(betAmount); // Player busts.
            System.out.println( "You busted! You lose your bet of $" + betAmount);

        } else if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
            player.winChips(betAmount); // Player wins
            System.out.println("Congratulations, the house don't always win after all");

            
        } else if (dealer.getScore() > player.getScore()) {
            player.loseChips(betAmount); // Dealer wins
            
        }
    }
    
}//end class
