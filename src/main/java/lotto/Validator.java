package lotto;

import static lotto.ErrorMessages.*;

public class Validator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int LOTTO_PRICE = 1000;

    public static int checkIsInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        checkIsPositive(amount);
        checkDividedOneThousand(amount);
    }

    private static void checkIsPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_SIGN);
        }
    }

    private static void checkDividedOneThousand(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT);
        }
    }

    public static void validateBonus(int bonus) {
        if (bonus < START_RANGE || bonus > END_RANGE) {
            throw new IllegalArgumentException(INVALID_BONUS_RANGE);
        }
    }
}
