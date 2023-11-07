package lotto.utils;

public class Validator {
    private static final String NUM_REGEX = "[0-9]+";

    public static boolean isNumber (String input) {
        if (!input.matches(NUM_REGEX)) {
            return false;
        }
        return true;
    }

    public static boolean validateBuyAmount(String buyAmount) {
        int amount = Integer.parseInt(buyAmount);
        if (amount < 1000 || amount % 1000 != 0) {
            return false;
        }
        return true;
    }
}
