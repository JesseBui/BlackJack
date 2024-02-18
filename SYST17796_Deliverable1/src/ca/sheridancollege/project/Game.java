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

    private final String name = "Black Jack"; // name of the game
    private String playerName;
    private Player player;
    private int startingChips;
    private Dealer dealer;
    private Deck deck;
    private int betAmount;
    Scanner scanner = new Scanner(System.in);
    public Game(String playername,int startingChips) {
        this.startingChips = startingChips ;
        this.player = new Player(playerName,startingChips);
        this.dealer = new Dealer();
        this.playerName = playername;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void startNewRound(){
        player.resetHand();
        dealer.resetHand();
        this.deck =new Deck();
        deck.shuffle();
        System.out.println("How much do you want to bet ");
        betAmount= scanner.nextInt();
        //  Give each player a hand
        player.drawCard(deck.drawCard());
        dealer.drawCard(deck.drawCard());
        player.drawCard(deck.drawCard());
        dealer.drawCard(deck.drawCard());

        // Player's turn
        dealer.displayHand();
        System.out.println(" ");
        System.out.println(player.toString());
        while (player.getScore() < 21) {
            System.out.println("HIT OR STAND(type 1 for hit  and type 2 for stand):");
            int choice = scanner.nextInt();
            if (choice == 1){
                player.drawCard(deck.drawCard());
                System.out.println(player.toString());
            } 
            else if(choice ==2){
                break; 
            }
        }
        // Dealer's turn
        dealer.toString();
        while (dealer.getScore() < 17) {
            dealer.drawCard(deck.drawCard());
        }
        if (player.getScore() > 21) {
            player.loseChips(betAmount);
            System.out.println( "You busted! You lose your bet of $" + betAmount);

        } else if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
            player.winChips(betAmount);
            System.out.println("Congratulations, the house don't always win after all");

            
        } else if (dealer.getScore() > player.getScore()) {
            player.loseChips(betAmount);
            
        }
    }
    
}//end class
