/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Khang Bui
 * @author Tin Nguyen
 */
public class Player {

    private String name; // The unique name for this player.
    private ArrayList<Card> hand; // The player's hand of cards.
    private int score; // The player's current score.
    private int chips; // The player's current chips (game currency).
    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name, int chips) {
        this.name = name; // Initialize the player's name.
        this.hand = new ArrayList<Card>(); // Initialize the player's hand as an empty ArrayList.
        this.score = 0; // Initialize the player's score to 0.
        this.chips = chips; // Initialize the player's chips to the specified amount.
    }

    // Method to add a card to the player's hand and update the score.
    public void drawCard(Card card) {
        this.hand.add(card); // Add the card to the player's hand.
        this.score += findCardValue(card); // Update the player's score based on the card drawn.
    }

    // Method to reset the player's hand and score.
    public void resetHand() {
        this.hand.clear(); // Clear the player's hand.
        this.score = 0; // Reset the player's score to 0.
    }
    
    // Private helper method to find the value of a card.
    private int findCardValue(Card card) {
        String value = card.getValue(); // Get the value of the card.
        switch(value) {
            case "Ace":
                return 11;
            case "King":
            case "Queen":
            case "Jack":
                return 10;
            default:
                return Integer.parseInt(value);
        }
    }
    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    // Getter method to retrieve the player's score.
    public int  getScore() {
        return score;
    }

    // Getter method to retrieve the player's chips.
    public int getChips() {
        return this.chips;
    }

    // Method to add chips to the player's total.
    public void winChips(int amount) {
        this.chips += amount; // Increase the player's chips by the specified amount.
    }

    // Method to deduct chips from the player's total.
    public void loseChips(int amount) {
        this.chips -= amount; // Decrease the player's chips by the specified amount.
    }

    // Method to represent the Player object as a string.
    @Override
    public String toString() {
        return "Player Hand: " + hand.toString() + ", Score: " + this.score;
    }

} //End class.
