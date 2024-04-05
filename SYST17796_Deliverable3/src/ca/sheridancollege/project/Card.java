/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves
 * as a modifier.
 *
 * @author Khang Bui
 */
public class Card {
    private String suit; // The suit of the card.
    private String value; // The value of the card.

    // Constructor to create a new Card object with a specified suit and value.
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    // Getter method to retrieve the suit of the card.
    public String getSuit() {
        return suit;
    }

    // Getter method to retrieve the value of the card.
    public String getValue() {
        return value;
    }

    // Method to represent the Card object as a string.
    @Override
    public String toString() {
        return value + " of " + suit;
    }

} // end class
