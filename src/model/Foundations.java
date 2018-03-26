package model;

import java.util.Stack;

/**
 * Class representing the Foundation piles of Solitaire.
 */
public class Foundations {

    /**
     * The four Stacks that make up the Foundations.
     */
    private Stack<Card> spades;
    private Stack<Card> diamonds;
    private Stack<Card> clubs;
    private Stack<Card> hearts;

    /**
     * Public constructor for Foundations object.
     */
    public Foundations() {
        this.spades = new Stack<>();
        this.diamonds = new Stack<>();
        this.clubs = new Stack<>();
        this.hearts = new Stack<>();
    }

    /**
     * Adds the given card to its corresponding Stack if it is in the correct order.
     *
     * @param toAdd
     *          the card to add to Foundations
     *
     * @return true if the addition is successful, otherwise false
     */
    public boolean addToFoundation(Card toAdd) {
        boolean canAdd = false;
        switch (toAdd.getSuit()) {
            case 0:
                if (toAdd.getValue() == 1 || (!spades.isEmpty() && spades.peek().canStack(toAdd))) {
                    spades.push(toAdd);
                    canAdd = true;
                }
                break;

            case 1:
                if (toAdd.getValue() == 1 || (!diamonds.isEmpty() && diamonds.peek().canStack(toAdd))) {
                    diamonds.push(toAdd);
                    canAdd = true;
                }
                break;

            case 2:
                if (toAdd.getValue() == 1 || (!hearts.isEmpty() && hearts.peek().canStack(toAdd))) {
                    hearts.push(toAdd);
                    canAdd = true;
                }
                break;

            case 3:
                if (toAdd.getValue() == 1 || (!clubs.isEmpty() && clubs.peek().canStack(toAdd))) {
                    clubs.push(toAdd);
                    canAdd = true;
                }
                break;

            default:
                break;
        }

        return canAdd;
    }

    /**
     * Checks to see if the player has won by filling all foundations.
     *
     * @return true if the foundations are full, otherwise false
     */
    public boolean checkForFullFoundations() {
        boolean full = true;
        if (spades.size() != 13 || diamonds.size() != 13 || hearts.size() != 13 || clubs.size() != 13) {
            full = false;
        }
        return full;
    }

    /**
     * Prints the top card in each Stack.
     */
    public void printFoundations() {
        String spade = "Empty";
        String diamond = "Empty";
        String club = "Empty";
        String heart = "Empty";

        if (!spades.isEmpty()) {
            spade = spades.peek().toString();
        }

        if (!diamonds.isEmpty()) {
            diamond = diamonds.peek().toString();
        }

        if (!clubs.isEmpty()) {
            club = clubs.peek().toString();
        }

        if (!hearts.isEmpty()) {
            heart = hearts.peek().toString();
        }

        System.out.println(String.format("Foundations: %20s %20s %20s %20s", spade, diamond, club, heart));
    }
}
