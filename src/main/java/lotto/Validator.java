package lotto;

import static lotto.ErrorMessages.INVALID_BONUS_RANGE;
import static lotto.ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT;

public class Validator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;

    public static int checkIsInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        checkIsPositive(amount);
    }

    private static void checkIsPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT);
        }
    }

    public static void validateBonus(int bonus) {
        if (bonus < START_RANGE || bonus > END_RANGE) {
            throw new IllegalArgumentException(INVALID_BONUS_RANGE);
        }
    }
}
