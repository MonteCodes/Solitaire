package controller;

import model.*;
import utilities.InputChecker;
import utilities.PrettyPrinter;

import java.util.Scanner;

/**
 * The main game class.
 */
public class Game {

    /**
     * The necessary components of a Solitaire game.
     */
    private Deck deck;
    private Foundations foundations;
    private Tableau tableau;
    private WastePile wastePile;
    /**
     * The input stream.
     */
    private Scanner in;

    /**
     * Public constructor for a Game.
     *
     * @param in the input stream
     */
    public Game(Scanner in) {
        this.deck = new Deck();
        this.foundations = new Foundations();
        this.tableau = new Tableau(this.deck);
        this.wastePile = new WastePile();
        this.in = in;
    }

    /**
     * Starts and runs the game.
     */
    public void start() {
        while (!foundations.checkForFullFoundations()) {
            turnStart();
            String fromInput = in.nextLine();
            while (!InputChecker.checkForValidInput(fromInput)) {
                PrettyPrinter.printTakeOptions();
                fromInput = in.nextLine();
            }
            int from = Integer.parseInt(fromInput);

            if (from >= 0 && from <= 6) {
                PrettyPrinter.printTableauPutOptions();
                String toInput = in.nextLine();
                while (!InputChecker.checkForValidInput(toInput)) {
                    PrettyPrinter.printTableauPutOptions();
                    toInput = in.nextLine();
                }
                int to = Integer.parseInt(toInput);

                if (to == 7) {
                    tableau.transferToFoundation(from, foundations);
                } else if (to >= 0 && to <= 6){
                    tableau.transferBetweenPiles(from, to);
                }
                tableau.flipBottomCard();

            } else if (from == 7 && !deck.isEmpty()) {
                Card toAdd = deck.dealCard();
                toAdd.flipCard();
                System.out.println("Drawn Card: " + toAdd);
                moveFromNonTableau(toAdd);

            } else if (from == 8 && wastePile.canTakeFromWaste()) {
                Card toAdd = wastePile.takeFromWaste();
                System.out.println("Drawn Card: " + toAdd);
                moveFromNonTableau(toAdd);

            } else {
                System.out.println("You cannot make the desired move");
            }
        }
    }

    /**
     * Moves a card from a non-tableau pile.
     *
     * @param toAdd the card being moved
     */
    private void moveFromNonTableau(Card toAdd) {
        PrettyPrinter.printNonTableauPutOptions();

        String toInput = in.nextLine();
        while (!InputChecker.checkForValidInput(toInput)) {
            PrettyPrinter.printNonTableauPutOptions();
            toInput = in.nextLine();
        }
        int to = Integer.parseInt(toInput);

        if (to == 8) {
            wastePile.addToWaste(toAdd);
        } else if (to == 7) {
            foundations.addToFoundation(toAdd);
        } else if (to >= 0 && to <= 6) {
            tableau.addToTableau(to, toAdd);
        }
    }

    /**
     * Prints the tableau, foundation, waste pile, and the take options.
     */
    private void turnStart() {
        this.tableau.printTableau();
        this.foundations.printFoundations();
        this.wastePile.peekWaste();
        PrettyPrinter.printTakeOptions();
    }
}
