package ca.sheridancollege.project;
import java.util.Scanner;
/**
  * @author Khang Bui
 * @author Tin Nguyen
 **/
public class BlackJack {
    public static void main(String[] args) {
        // Create a new game with 100 starting chips
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you mind telling us your name? ");
        String name = scanner.nextLine(); 
        Game game = new Game(name, 100);

        // Start a new round
        while (game.getPlayer().getChips()>0) {
            System.out.println("Welcome to the casino "+ name + " what would you like to do today? Oh "+ game.getName() + " of course! Let's start a new round!");
            game.startNewRound();
        
            // Display the player's hand and score
            System.out.println(game.getPlayer().toString());
    
            // Display the dealer's hand and score
            System.out.println(game.getDealer().toString());   
            // Display player'status
            System.out.println("You now have " + game.getPlayer().getChips() + " chips.");
            // Give player option to stop the game
            System.out.println("Do you want to continue playing? (yes/no)");
            String answer = scanner.nextLine();
                
            if (answer.equals("no")) {
                break;
            }
        }
        System.out.println("You've run out of chips! Guess you ran out of luck today.");
    }
} // end class
