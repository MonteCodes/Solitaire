package utilities;

public final class InputChecker {

    public static boolean checkForValidInput(String input) {
        try {
            int inputValue = Integer.parseInt(input);
            return inputValue >= 0 && inputValue <= 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
