package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                    LottoErrorMessageConstants.WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage()
            );
        }
        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.WINNING_NUMBER_DUPLICATE_INPUT_ERROR_MESSAGE.getMessage()
            );
        }
        for (int winningNumber : winningNumbers) {
            if (isNotNumberInLottoBoundary(winningNumber)) {
                throw new IllegalArgumentException(
                        LottoErrorMessageConstants.WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage()
                );
            }
        }
    }

    public static void bonusNumberIsValid(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.BONUS_NUMBER_IS_CONTAINS_WINNING_NUMBER.getMessage()
            );
        }
        if (isNotNumberInLottoBoundary(bonusNumber)) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.BONUS_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage()
            );
        }
    }

    private static boolean isNotNumberInLottoBoundary(int number) {
        return LottoConstants.LOTTO_START_NUMBER.getConstant() > number
                || number > LottoConstants.LOTTO_END_NUMBER.getConstant();
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
        return notDuplicateNumbers.size() != LottoConstants.LOTTO_PER_NUMBERS.getConstant();
    }
}
