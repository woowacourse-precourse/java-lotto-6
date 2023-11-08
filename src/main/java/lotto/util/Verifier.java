package lotto.util;

import lotto.enums.ErrorMsg;

import java.util.List;

public class Verifier {
    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_PURCHASE_AMOUNT_RANGE.getErrMsg());
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_PURCHASE_AMOUNT_UNIT.getErrMsg());
        }
    }

    public static void validateWinningNumberInput(String winningNumberInput) {
        if (!winningNumberInput.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_WINNING_NUMBER.getErrMsg());
        }
    }

    public static void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_COUNT.getErrMsg());
        }

        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_DUPLICATE.getErrMsg());
        }
    }

    public static void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_BONUS_NUMBER_RANGE.getErrMsg());
        }
    }

    public static void validateOnlyNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_ONLY_NUMBER.getErrMsg());
        }
    }
}
