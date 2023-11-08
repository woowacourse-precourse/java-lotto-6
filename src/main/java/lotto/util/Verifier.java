package lotto.util;

import lotto.enums.ErrorMsg;

public class Verifier {
    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_PURCHASE_AMOUNT_RANGE.getErrMsg());
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_PURCHASE_AMOUNT_UNIT.getErrMsg());
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        if (!winningNumbers.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_WINNING_NUMBER.getErrMsg());
        }
    }

    public static void validateOnlyNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_ONLY_NUMBER.getErrMsg());
        }
    }
}
