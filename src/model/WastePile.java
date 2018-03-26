package model;

import java.util.Stack;

public class WastePile {

    private Stack<Card> waste;

    public WastePile() {
        waste = new Stack<>();
    }

    public void addToWaste(Card card) {
        waste.push(card);
    }

    public Card takeFromWaste() {
        return waste.pop();
    }

    public boolean canTakeFromWaste() {
        return !waste.isEmpty();
    }

    public void peekWaste() {
        if (canTakeFromWaste()) {
            System.out.println("Waste: " + waste.peek());
        }
    }
}
