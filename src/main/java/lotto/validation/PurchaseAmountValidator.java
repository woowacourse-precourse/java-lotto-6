package lotto.validation;

import lotto.utils.Constants;

public class PurchaseAmountValidator {

    public static void validateIsNumeric(String str) {
        if (!str.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(Constants.NON_NUMERIC_MSG);
        }
    }

    public static void validateIsPositive(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(Constants.NON_POSITIVE_MSG);
        }
    }

    public static void validateIsDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % Constants.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(Constants.NOT_DIVISIBLE_MSG);
        }
    }
}
