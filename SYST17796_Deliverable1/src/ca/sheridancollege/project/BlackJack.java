package ca.sheridancollege.project;
/**
  * @author Khang Bui
 * @author Tin Nguyen
 **/
public class BlackJack {
    public static void main(String[] args) {
        // Create a new game with 100 starting chips
        Game game = new Game("Player 1", 100);

        // Start a new round
        while (game.getPlayer().getChips()>0) {
            System.out.println("Welcome to the BlackJack table!");
            game.startNewRound();
        //Sanb
            // Display the player's hand and score
            System.out.println(game.getPlayer().toString());
    
            // Display the dealer's hand and score
            System.out.println(game.getDealer().toString());   

            System.out.println("You now have " + game.getPlayer().getChips() + " chips.");
        }
        System.out.println("You've run out of chips! Game over.");
    }
}
