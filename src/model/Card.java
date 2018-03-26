package model;

public class Card {

    private int suit;
    private int value;
    private boolean flipped;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
        this.flipped = false;
    }

    public void flipCard() {
        this.flipped = !this.flipped;
    }

    public boolean canStack(Card toStack) {
        return this.value == toStack.value - 1;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

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
        if (this.flipped) {
            return cardName() + " " + suitName();
        } else {
            return "Covered";
        }
    }
}
