package utilities;

/**
 * Utility class for printing game options.
 */
public final class PrettyPrinter {

    /**
     * Prints the take options.
     */
    public static void printTakeOptions() {
        System.out.println("\nWhere would you like to move a card from?\n" +
                "0: First pile\n" +
                "1: Second pile\n" +
                "2: Third pile\n" +
                "3: Fourth pile\n" +
                "4: Fifth pile\n" +
                "5: Sixth pile\n" +
                "6: Seventh pile\n" +
                "7: Stock pile\n" +
                "8: Waste pile");
        System.out.print("Enter: ");
    }

    /**
     * Prints the put options for non-tableau cards.
     */
    public static void printNonTableauPutOptions() {
        System.out.println("\nWhere would you like to move the card to?\n" +
                "0: First pile\n" +
                "1: Second pile\n" +
                "2: Third pile\n" +
                "3: Fourth pile\n" +
                "4: Fifth pile\n" +
                "5: Sixth pile\n" +
                "6: Seventh pile\n" +
                "7: Foundations\n" +
                "8: Waste pile");
        System.out.print("Enter: ");
    }

    /**
     * Prints the put options for tableau transfers.
     */
    public static void printTableauPutOptions() {
        System.out.println("\nWhere would you like to move the card to?\n" +
                "0: First pile\n" +
                "1: Second pile\n" +
                "2: Third pile\n" +
                "3: Fourth pile\n" +
                "4: Fifth pile\n" +
                "5: Sixth pile\n" +
                "6: Seventh pile\n" +
                "7: Foundations");
        System.out.print("Enter: ");
    }
}
