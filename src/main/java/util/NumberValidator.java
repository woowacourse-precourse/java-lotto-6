package util;

public class NumberValidator {

    public static void validatePurchaseAmount(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }
    }

}
