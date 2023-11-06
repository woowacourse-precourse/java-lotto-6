package lotto.utils;

import static lotto.contents.ContentErrors.INPUT_OUT_OF_RANGE;
import static lotto.contents.ContentErrors.INVALID_OUT_OF_RANGE;
import static lotto.contents.ContentNumbers.LOTTO_BUY_MAX;
import static lotto.contents.ContentNumbers.LOTTO_PRICE;
import static lotto.contents.ContentNumbers.LOTTO_STRING_LENGTH;
import static lotto.contents.ContentNumbers.LOTTO_STRING_LENGTH_WINNING_NUMBER;
import static lotto.contents.ContentNumbers.ZERO;
import static lotto.contents.ContentNumbers.LOTTO_MIN_NUMBER;
import static lotto.contents.ContentNumbers.LOTTO_MAX_NUMBER;
import static lotto.contents.ContentNumbers.LOTTO_NUMBERS_COUNT;
import static lotto.contents.ContentErrors.INVALID_AMOUNT;
import static lotto.contents.ContentErrors.NEGATIVE_AMOUNT;
import static lotto.contents.ContentErrors.INVALID_RANGE;
import static lotto.contents.ContentErrors.DUPLICATE_NUMBER;
import static lotto.contents.ContentErrors.INVALID_NUMBER_FORMAT;
import static lotto.contents.ContentErrors.VALID_LOTTO_NUMBERS_COUNT;
import static lotto.contents.ContentErrors.BLANK_SPACE_IN_INPUT;
import static lotto.contents.ContentErrors.INVALID_BONUS_NUMBER;
import static lotto.contents.ContentErrors.BONUS_NUMBER_DUPLICATE;

import java.util.List;

public class ValidationUtil {
    public static void validateNonNegative(int amount) {
        if (amount < ZERO.getNumber()) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT.getErrorMessage());
        }
    }

    public static void validateThousandUnit(int amount) {
        if (amount % LOTTO_PRICE.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getErrorMessage());
        }
    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_SPACE_IN_INPUT.getErrorMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER.getNumber() || number > LOTTO_MAX_NUMBER.getNumber())) {
            throw new IllegalArgumentException(INVALID_RANGE.getErrorMessage());
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public static void validateCorrectNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new IllegalArgumentException(VALID_LOTTO_NUMBERS_COUNT.getErrorMessage());
        }
    }

    public static void validateSpecialCharacters(String input) {
        if (!input.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }

    public static void validateOutOfRange(String input) {
        if (input.length() > LOTTO_STRING_LENGTH.getNumber()) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE.getErrorMessage());
        }
    }

    public static void validateWinningNumbersOutOfRange(String input) {
        if (input.length() > LOTTO_STRING_LENGTH_WINNING_NUMBER.getNumber()) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE.getErrorMessage());
        }
    }

    public static void validatePurchaseAmountRange(int input) {
        if (input > LOTTO_BUY_MAX.getNumber()) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getErrorMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER.getNumber() || bonusNumber > LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getErrorMessage());
        }
    }

    public static void validateBonusNumberNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }
}
