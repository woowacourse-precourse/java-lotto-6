package lotto;

import static lotto.constants.ErrorMessage.*;
import static lotto.constants.LottoConfig.*;

import lotto.constants.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoConfig.NUMBER_LENGTH;

public class Validator {
    public static boolean isUniqueNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .toList()
                .size() == NUMBER_LENGTH.getValue();
    }

    public static void validatePayment(String payment) {
        if (!payment.chars()
                    .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public static void containOnlyDigit(String input) {
        if (!input.chars()
                  .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NUMBER_FORMAT.getMessage());
        }
    }

    public static boolean containOnlyDigitTest(String input) {
        return input.chars()
                    .allMatch(Character::isDigit);
    }

    public static void containOnlyDigit(String[] inputNumbers) {
        for (String input : inputNumbers) {
            containOnlyDigit(input);
        }
    }

    public static void isValidSize(List<Integer> numbers) {
        if (!(numbers.size() == NUMBER_LENGTH.getValue())) {
            throw new IllegalArgumentException(NOT_VALID_SIZE.getMessage());
        }
    }

    public static void isDigitInValidRange(List<Integer> numbers) {
        if (!numbers.stream()
                    .allMatch(i ->
                            RANDOM_RANGE_MIN_NUMBER.getValue() <= i
                                    && i <= RANDOM_RANGE_MAX_NUMBER.getValue())) {
            throw new IllegalArgumentException(NOT_VALID_RANGE.getMessage());
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        if (numbers.stream()
                   .distinct()
                   .count() != NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException(NOT_DUPLICATED.getMessage());
        }
    }
}
