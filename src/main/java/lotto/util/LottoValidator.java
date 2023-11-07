package lotto.util;

import static lotto.constant.ExceptionMessages.BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.PURCHASE_AMOUNT_RANGE_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.constant.ExceptionMessages.WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE;
import static lotto.constant.GameOptions.MAX_NUMBER;
import static lotto.constant.GameOptions.MIN_NUMBER;
import static lotto.constant.GameOptions.NUMBER_COUNT;
import static lotto.constant.GameOptions.PRICE;

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
        if (purchaseAmount % PRICE.getValue() != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_EXCEPTION_MESSAGE.toString());
        }
    }

    private static void validateOverMinimum(Integer purchaseAmount) {
        if (purchaseAmount < PRICE.getValue()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_EXCEPTION_MESSAGE.toString());
        }
    }

    public static void validateWinningNumber(WinningNumber winningNumber) {
        List<Integer> numbers = winningNumber.getNumbers();

        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
    }

    public static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_COUNT_EXCEPTION_MESSAGE.toString());
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateNumberRange);
    }

    private static void validateNumberRange(Integer number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE.toString());
        }
    }

    public static void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (set.contains(number)) {
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_EXCEPTION_MESSAGE.toString());
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
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE.toString());
        }
    }

}
