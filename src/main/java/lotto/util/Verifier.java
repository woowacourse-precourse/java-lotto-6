package lotto.util;

import lotto.enums.ErrorMsg;
import lotto.enums.LottoNumber;

import java.util.List;

public class Verifier {
    private static final int DIVIDED_ZERO = 0;

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < LottoNumber.PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_PURCHASE_AMOUNT_RANGE.getErrMsg());
        }

        if (purchaseAmount % LottoNumber.PRICE.getNumber() != DIVIDED_ZERO) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_PURCHASE_AMOUNT_UNIT.getErrMsg());
        }
    }

    public static void validateWinningNumberInput(String winningNumberInput) {
        if (!winningNumberInput.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_WINNING_NUMBER.getErrMsg());
        }
    }

    public static void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoNumber.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_COUNT.getErrMsg());
        }

        if (winningNumbers.stream().distinct().count() != LottoNumber.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_DUPLICATE.getErrMsg());
        }
    }

    public static void validateBonusNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        if (LottoNumber.isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_BONUS_NUMBER_RANGE.getErrMsg());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_BONUS_NUMBER_DUPLICATE.getErrMsg());
        }
    }

    public static void validateOnlyNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_ONLY_NUMBER.getErrMsg());
        }
    }
}
