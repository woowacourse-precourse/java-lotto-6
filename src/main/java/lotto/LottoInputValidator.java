package lotto;

import java.util.List;

public class LottoInputValidator {
    public static void purchasePriceIsValid(int purchasePrice) {
        if (purchasePrice % LottoConstants.LOTTO_PRICE.getConstant() != 0) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE.getMessage()
            );
        }
    }

    public static void WinningNumbersIsValid(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoConstants.LOTTO_PER_NUMBERS.getConstant()) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.WINNER_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage()
            );
        }
        for (int winningNumber : winningNumbers) {
            if (LottoConstants.LOTTO_START_NUMBER.getConstant() > winningNumber
                    && winningNumber > LottoConstants.LOTTO_END_NUMBER.getConstant()) {
                throw new IllegalArgumentException(
                        LottoErrorMessageConstants.WINNER_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage()
                );
            }
        }
    }
}
