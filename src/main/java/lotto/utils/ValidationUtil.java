package lotto.utils;

import static lotto.contents.ContentNumbers.LOTTO_PRICE;
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

import java.util.List;

public class ValidationUtil {
    // 구매금액이 음수인지 검사합니다.
    public static void validateNonNegative(int amount) {
        if (amount < ZERO.getNumber()) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT.getErrorMessage());
        }
    }
    // 구매금액이 1000단위로 나누어 떨어지는지 검사합니다.
    public static void validateThousandUnit(int amount) {
        if (amount % LOTTO_PRICE.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getErrorMessage());
        }
    }

    // 입력값이 null이거나 공백만 있는지 검사합니다.
    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_SPACE_IN_INPUT.getErrorMessage());
        }
    }
    // 각 숫자가 1~45 범위에 있는지 검사합니다.
    public static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_MAX_NUMBER.getNumber() || number > LOTTO_MIN_NUMBER.getNumber())) {
            throw new IllegalArgumentException(INVALID_RANGE.getErrorMessage());
        }
    }
    // 숫자들 사이에 중복이 없는지 검사합니다.
    public static void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getErrorMessage());
        }
    }
    // 정확히 6개의 숫자가 입력되었는지 검사합니다.
    public static void validateCorrectNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT.getNumber()) {
            throw new IllegalArgumentException(VALID_LOTTO_NUMBERS_COUNT.getErrorMessage());
        }
    }
    // 입력된 문자열이 숫자와 쉼표로만 이루어져 있는지 검사합니다.
    public static void validateSpecialCharacters(String input) {
        if (!input.matches("^\\d+(,\\d+){5}$")) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }
}
