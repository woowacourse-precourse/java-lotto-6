package lotto;

public class Exception {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public boolean inputTypeException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }


}
