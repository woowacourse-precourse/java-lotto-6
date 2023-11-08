package lotto.validator;

import static lotto.message.ErrorMessages.*;
import static lotto.util.Util.*;

public class InputValidator {

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
