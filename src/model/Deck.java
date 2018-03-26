package model;

import java.util.Collections;
import java.util.Stack;

/**
 * Class representing a deck of Card objects.
 */
public class Deck {

    /**
     * The Stack that the deck will be modeled after.
     */
    private Stack<Card> deck;

    /**
     * Public constructor for Deck object that builds and shuffles a new deck.
     */
    public Deck() {
        this.deck = new Stack<>();
        buildDeck();
        shuffleDeck();
    }

    /**
     * Builds a typical deck of 52 cards.
     */
    private void buildDeck() {
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                this.deck.push(new Card(j, i));
            }
        }
    }

    /**
     * Randomizes the order of the deck.
     */
    private void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * Pops off the top of the deck.
     *
     * @return the top Card object in the deck
     */
    public Card dealCard() {
        return this.deck.pop();
    }

    /**
     * Checks to see if the deck is out of Card objects.
     *
     * @return true if the deck is empty, otherwise false
     */
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }
}
