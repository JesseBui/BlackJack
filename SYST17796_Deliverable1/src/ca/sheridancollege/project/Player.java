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

    private String name; //the unique name for this player
    private ArrayList<Card> hand;
    private int score;
    private int chips;
    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name, int chips) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.score = 0;
        this.chips = chips;
    }
    
    public void drawCard(Card card) {
        this.hand.add(card);
        this.score += findCardValue(card);
    }

    public void resetHand() {
        this.hand.clear();
        this.score = 0;
    }
    

    private int findCardValue(Card card) {
        String value = card.getValue();
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

    public int  getScore() {
        return score;
    }

    public int getChips() {
        return this.chips;
    }

    public void winChips(int amount) {
        this.chips += amount;
    }

    public void loseChips(int amount) {
        this.chips -= amount;
    }

    @Override
    public String toString() {
        return "Player Hand: " + hand.toString() + ", Score: " + this.score;
    }

}
