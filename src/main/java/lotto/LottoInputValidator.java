package lotto;

import static lotto.enums.LottoConstants.LOTTO_END_NUMBER;
import static lotto.enums.LottoConstants.LOTTO_PER_NUMBERS;
import static lotto.enums.LottoConstants.LOTTO_PRICE;
import static lotto.enums.LottoConstants.LOTTO_START_NUMBER;
import static lotto.enums.LottoErrorMessageConstants.BONUS_NUMBER_INVALID_NUMBER_ERROR_MESSAGE;
import static lotto.enums.LottoErrorMessageConstants.BONUS_NUMBER_IS_CONTAINS_WINNING_NUMBER;
import static lotto.enums.LottoErrorMessageConstants.PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE;
import static lotto.enums.LottoErrorMessageConstants.WINNING_NUMBER_DUPLICATE_INPUT_ERROR_MESSAGE;
import static lotto.enums.LottoErrorMessageConstants.WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInputValidator {
    public static void purchasePriceIsValid(int purchasePrice) throws IllegalArgumentException {
        if (purchasePrice % LOTTO_PRICE.getConstant() != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE.getMessage());
        }
    }

    public static void WinningNumbersIsValid(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LOTTO_PER_NUMBERS.getConstant()) {
            throw new IllegalArgumentException(WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage());
        }
        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_INPUT_ERROR_MESSAGE.getMessage());
        }
        for (int winningNumber : winningNumbers) {
            if (isNotNumberInLottoBoundary(winningNumber)) {
                throw new IllegalArgumentException(WINNING_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage());
            }
        }
    }

    public static void bonusNumberIsValid(List<Integer> winningNumbers, int bonusNumber)
            throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_CONTAINS_WINNING_NUMBER.getMessage());
        }
        if (isNotNumberInLottoBoundary(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INVALID_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isNotNumberInLottoBoundary(int number) {
        return LOTTO_START_NUMBER.getConstant() > number || number > LOTTO_END_NUMBER.getConstant();
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
        return notDuplicateNumbers.size() != LOTTO_PER_NUMBERS.getConstant();
    }
}
