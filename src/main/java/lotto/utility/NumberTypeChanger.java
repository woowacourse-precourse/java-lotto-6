package lotto.utility;

public class NumberTypeChanger {
    private static final String MATCH_NUMBER = "\\d+";

    public static int changeNumberType(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(PurchaseErrorMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(MATCH_NUMBER);
    }
}
