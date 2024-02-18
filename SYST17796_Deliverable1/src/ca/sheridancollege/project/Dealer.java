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

    private ArrayList<Card> hand;
    private int score;
    /**
     * A constructor that allows you to set the Dealer's unique ID
     *
     * @param name the unique ID to assign to this Dealer.
     */
    public Dealer() {
        this.hand = new ArrayList<Card>();
        this.score = 0;
    }
    
    public void drawCard(Card card) {
        this.hand.add(card);
        this.score += findCardValue(card);
    }

    public void resetHand() {
        this.hand.clear();
        this.score = 0;
    }
    
    public int  getScore() {
        return score;
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

    public void displayHand() {
        System.out.print("Dealer Hand: ");
        for  (int i=0; i < hand.size(); i++) {
            System.out.print(hand.get(i).toString()+ ",");
            if (i == 1) {
                System.out.print("Hidden Card,  ");
            }
    }

    }
    @Override
    public String toString() {
        return "Dealer Hand: " + hand.toString() + ", Score: " + this.score;
    }

}

