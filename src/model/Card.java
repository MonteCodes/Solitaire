package model;

/**
 * Class representing a typical Card with a card value of:
 * [1(A), 2, 3, 4, 5, 6, 7, 8, 9, 10, 11(J), 12(Q), 13(K)]
 * and a suit value of:
 * [0(Spades), 1(Diamonds), 2(Hearts), 3(Clubs)].
 */
public class Card {

    /**
     * The value representative of the Card suit.
     */
    private int suit;
    /**
     * The value representative of the Card value.
     */
    private int value;
    /**
     * Boolean value representing whether the Card is face-up or face-down.
     */
    private boolean faceUp;

    /**
     * Public constructor for a Card object.
     *
     * @param suit  the given Card suit
     * @param value the given Card value
     */
    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
    }

    /**
     * Flips the Card from face-up to face-down or face-down to face-up.
     */
    public void flipCard() {
        this.faceUp = !this.faceUp;
    }

    /**
     * Determines whether the Card objects are consecutive in order.
     *
     * @param toStack the Card to check
     * @return true if the Card is consecutive. otherwise, false
     */
    public boolean canStack(Card toStack) {
        return this.value == toStack.value - 1;
    }

    /**
     * Checks if the Card object is face-up or face-down.
     *
     * @return true if the card is face-up. otherwise, false
     */
    public boolean isFaceUp() {
        return faceUp;
    }

    /**
     * Getter for the Card value.
     *
     * @return the value of the Card instance
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter for the Card suit
     *
     * @return the suit of the Card instance
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Private method for determining the name of the suit.
     *
     * @return the name of the Card instance suit
     */
    private String suitName() {
        switch (suit) {
            case 0:
                return "Spades";
            case 1:
                return "Diamonds";
            case 2:
                return "Hearts";
            case 3:
                return "Clubs";
            default:
                return null;

        }
    }

    /**
     * Private method for determining the name of the card value.
     *
     * @return the name representative of the Card value
     */
    private String cardName() {
        switch (value) {
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "" + value;
        }
    }

    @Override
    public String toString() {
        if (this.faceUp) {
            return cardName() + " " + suitName();
        } else {
            return "Covered";
        }
    }
}
