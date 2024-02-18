/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for
 * reuse.
 *
 * @author Khang Bui
 * @author Tin Nguyen
 */
public class Deck {

    // The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        String[] values = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

        for (String suit : suits) {
            for (String value : values) {
                this.cards.add(new Card(suit, value));
            }
        }
    }

    public Card drawCard() {
        return this.cards.remove(this.cards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}// end class
