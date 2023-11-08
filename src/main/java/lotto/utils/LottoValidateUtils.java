package lotto.utils;

import static lotto.constant.DomainConstant.LOTTO_SIZE;
import static lotto.constant.DomainConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.DomainConstant.MIN_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.DUPLICATE_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.constant.ErrorMessage.INVALID_NUMBER_OF_LOTTO_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidateUtils {

    public static void validateLottoNumbers(final List<Integer> numbers) {
        checkCorrectNumberOfNumbers(numbers, LOTTO_SIZE.getValue());
        ensureNumbersWithinRange(numbers);
        checkForDuplicateNumbers(numbers);
    }

    public static void validateBonusNumber(final int bonusNumber, final List<Integer> numbers) {
        ensureNumberWithinRange(bonusNumber);
        checkBonusNumberNotInMainNumbers(bonusNumber, numbers);
    }

    private static void checkCorrectNumberOfNumbers(final List<Integer> numbers, final int expectedSize) {
        if (numbers.size() != expectedSize) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void ensureNumberWithinRange(final int number) {
        if (isOutOfNumberInRange(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void ensureNumbersWithinRange(final List<Integer> numbers) {
        if (numbers.stream().anyMatch(LottoValidateUtils::isOutOfNumberInRange)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void checkForDuplicateNumbers(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    private static void checkBonusNumberNotInMainNumbers(final int bonusNumber, final List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

    private static boolean isOutOfNumberInRange(final int number) {
        return number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue();
    }
}
