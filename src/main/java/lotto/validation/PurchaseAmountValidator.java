package lotto.validation;

import lotto.utils.Constants;

public class PurchaseAmountValidator {

    public static void validateIsPositiveInteger(String str) {
        if (!str.matches("\\d+")) {
            throw new IllegalArgumentException(Constants.NOT_POSITIVE_INTEGER_MSG);
        }
    }

    public static void validateIsDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % Constants.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(Constants.NOT_DIVISIBLE_MSG);
        }
    }
}
