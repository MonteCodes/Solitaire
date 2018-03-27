package utilities;

/**
 * Utility class for checking input.
 */
public final class InputChecker {

    /**
     * Checks if a String contains a valid option.
     *
     * @param input the string to check
     * @return true if the input is valid. otherwise, false
     */
    public static boolean checkForValidInput(String input) {
        try {
            int inputValue = Integer.parseInt(input);
            return inputValue >= 0 && inputValue <= 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
