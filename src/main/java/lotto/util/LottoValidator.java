package lotto.util;

import static lotto.constant.ExceptionMessages.BONUS_NUMBER_DUPLICATION_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_DUPLICATION_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE;
import static lotto.constant.GameOptions.LOTTO_MAX_NUMBER;
import static lotto.constant.GameOptions.LOTTO_MIN_NUMBER;
import static lotto.constant.GameOptions.LOTTO_NUMBER_COUNT;
import static lotto.constant.GameOptions.LOTTO_PRICE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.WinningNumber;

public class LottoValidator {
    public static void validatePurchaseAmount(Integer purchaseAmount) {
        validateOverMinimum(purchaseAmount);
        validateDivisibility(purchaseAmount);
    }

    private static void validateDivisibility(Integer purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE.toString());
        }
    }

    private static void validateOverMinimum(Integer purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(MIN_PURCHASE_AMOUNT_EXCEPTION_MESSAGE.toString());
        }
    }

    public static void validateWinningNumber(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE.toString());
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateNumberRange);
    }

    private static void validateNumberRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE.toString());
        }
    }

    private static void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_EXCEPTION_MESSAGE.toString());
            }
            set.add(number);
        }
    }

    public static void validateBonusNumber(Integer bonus, WinningNumber winningNumbers) {
        validateNumberRange(bonus);
        validateBonusNumberDuplication(bonus, winningNumbers);
    }

    private static void validateBonusNumberDuplication(Integer bonus, WinningNumber winningNumbers) {
        if (winningNumbers.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION_MESSAGE.toString());
        }
    }

}
