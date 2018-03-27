package model;

import java.util.ArrayList;

/**
 * Class representing the Tableau used in Solitaire.
 */
public class Tableau {

    /**
     * An ArrayList of Card ArrayLists that models the Tableau
     */
    private ArrayList<ArrayList<Card>> tableau;

    /**
     * Public Constructor for a Tableau object.
     *
     * @param deck the deck to deal the tableau from
     */
    public Tableau(Deck deck) {
        tableau = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tableau.add(new ArrayList<>());
        }
        dealTableau(deck);
    }

    /**
     * Deals cards from the deck as such (U meaning face-up, D meaning face-down):
     * <p>
     * U D D D D D D
     * U D D D D D
     * U D D D D
     * U D D D
     * U D D
     * U D
     * U
     *
     * @param d the deck to deal from
     */
    private void dealTableau(Deck d) {
        for (int i = 0; i < tableau.size(); i++) {
            for (int j = 0; j < i; j++) {
                tableau.get(i).add(d.dealCard());
            }
            Card last = d.dealCard();
            last.flipCard();
            tableau.get(i).add(last);
        }
    }

    /**
     * Transfers a Card from the indicated Tableau pile to the Foundation.
     *
     * @param from       the tableau pile index
     * @param foundation the foundation to transfer to
     * @return true if the transfer is successful. otherwise, false
     */
    public boolean transferToFoundation(int from, Foundations foundation) {

        Card lastInFrom = tableau.get(from).get(tableau.get(from).size() - 1);

        if (foundation.addToFoundation(lastInFrom)) {
            tableau.get(from).remove(lastInFrom);
            return true;
        }

        return false;
    }

    /**
     * Transfers a Card from the indicated Tableau pile to another Tableau pile.
     *
     * @param from the pile to transfer from
     * @param to   the pile to transfer to
     * @return true if the transfer is successful. otherwise, false
     */
    public boolean transferBetweenPiles(int from, int to) {

        ArrayList<Card> fromPile = tableau.get(from);
        ArrayList<Card> toPile = tableau.get(to);
        Card firstFlipped = fromPile.get(0);
        boolean found = false;
        for (int i = 0; i < fromPile.size() && !found; i++) {
            if (fromPile.get(i).isFaceUp()) {
                firstFlipped = fromPile.get(i);
                found = true;
            }
        }

        if ((!toPile.isEmpty() && firstFlipped.canStack(toPile.get(toPile.size() - 1))) || (toPile.isEmpty() && firstFlipped.getValue() == 13)) {
            ArrayList<Card> flipped = new ArrayList<>();
            for (Card c : tableau.get(from)) {
                if (c.isFaceUp()) {
                    tableau.get(to).add(c);
                    flipped.add(c);
                }
            }
            tableau.get(from).removeAll(flipped);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds the given card to the indicated Tableau pile.
     *
     * @param to
     *          the pile to transfer to
     * @param card
     *          the card to add
     *
     * @return true if the transfer is successful. otherwise, false
     */
    public boolean addToTableau(int to, Card card) {
        if (tableau.get(to).isEmpty() && card.getValue() == 13) {
            tableau.get(to).add(card);
            return true;
        } else if (card.canStack(tableau.get(to).get(tableau.get(to).size() - 1))) {
            tableau.get(to).add(card);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks to see if all bottom cards in the piles are flipped correctly.
     * If one isn't, it is flipped.
     */
    public void flipBottomCard() {
        for (ArrayList<Card> pile : tableau) {
            if (!pile.isEmpty()) {
                Card last = pile.get(pile.size() - 1);
                if (!last.isFaceUp()) {
                    last.flipCard();
                }
            }
        }
    }

    /**
     * Prints the Tableau.
     */
    public void printTableau() {
        final int MAX_SIZE = 13;

        for (int i = 0; i < MAX_SIZE; i++) {
            StringBuilder row = new StringBuilder();
            for (ArrayList<Card> current : tableau) {
                if (current.size() > i) {
                    String c = String.format("%20s", current.get(i));
                    row.append(c);
                } else {
                    String c = String.format("%20s", "");
                    row.append(c);
                }
            }
            System.out.println(String.format("%140s", row.toString()));
        }
    }
}
