/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 * A class that models each Dealer in the game. Dealers have an identifier, which should be unique.
 *
 * @author Khang Bui
 * @author Tin Nguyen
 */
public class Dealer {

    private ArrayList<Card> hand; // The dealer's hand of cards.
    private int score; // The dealer's current score.
    /**
     * A constructor that allows you to set the Dealer's unique ID
     *
     * @param name the unique ID to assign to this Dealer.
     */
    public Dealer() {
        this.hand = new ArrayList<Card>(); // Initialize the dealer's hand as an empty ArrayList.
        this.score = 0; // Initialize the dealer's score to 0.
    }

    //Method to add a card to the dealer's hand and update the score.
    public void drawCard(Card card) {
        this.hand.add(card); // Add the card to the dealer's hand.
        this.score += findCardValue(card); // Update the dealer's score based on the card drawn.
    }

    //Method to reset the dealer's hand and score.
    public void resetHand() {
        this.hand.clear(); // Clear the dealer's hand.
        this.score = 0; // Reset the dealer's score to 0
    }

    // Getter method to retrieve the dealer's score.
    public int  getScore() {
        return score; // Return the dealer's score.
    }

    //Private helper method to find the value of a card.
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

    //Method to display the dealer's hand.
    public void displayHand() {
        System.out.print("Dealer Hand: "); // Print the dealer's hand label
        for  (int i=0; i < hand.size(); i++) {
            System.out.print(hand.get(i).toString()+ ","); // Print each card in the dealer's hand
            if (i == 1) {
                System.out.print("Hidden Card,  "); // For the second card, display as "Hidden Card"
            }
    }

    }

    //Method to represent the Dealer object as a string.
    @Override
    public String toString() {
        return "Dealer Hand: " + hand.toString() + ", Score: " + this.score; //return the dealer's hand and score.
    }

}

