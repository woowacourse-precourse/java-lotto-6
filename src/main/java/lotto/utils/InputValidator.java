package lotto.utils;

public class InputValidator {
    public static void validatePayNumber(String pay) {
        checkNumber(pay);
        checkNegativeNumber(pay);
    }

    private static void checkNumber(String number) {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    public static void checkNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
