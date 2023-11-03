package util;

public class NumberValidator {

    public static void validatePurchaseAmount(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }

        if (!isNumeric(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
        }

        if (!isWithinIntRange(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.OUT_OF_INT_RANGE.getMessage());
        }
    }

    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isWithinIntRange(String number) {
        int maxValue = Integer.MAX_VALUE;

        if (Integer.parseInt(number) <= maxValue) {
            return true;
        }
        return false;
    }
}
