package lotto.utils.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.message.WinningInformationExceptionMessage;

public class WinningNumberValidator {

    private static final int MAX_LENGTH = 20;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final char COMMA = ',';

    public static void validate(String input) {
        validateBlank(input);
        validateSize(input);
        validateFirstCharacterIsComma(input);
        validateLastCharacterIsComma(input);

        List<String> winningNumbers = Arrays.asList(input.split(","));
        validateEachNumberIsNumeric(winningNumbers);
        validateEachNumberIsInRange(winningNumbers);
        validateDuplicate(winningNumbers);
        validateTotalCount(winningNumbers);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.BLANK.getError());
        }
    }

    private static void validateSize(String target) {
        if (target.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    WinningInformationExceptionMessage.EXCEED_WINNING_NUMBER_LENGTH.getError());
        }
    }

    private static void validateFirstCharacterIsComma(String target) {
        if (target.charAt(0) == COMMA) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.FIRST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateLastCharacterIsComma(String target) {
        if (target.charAt(target.length() - 1) == COMMA) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.LAST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateEachNumberIsNumeric(List<String> target) {
        boolean isNotNumericExists = target.stream()
                .anyMatch(WinningNumberValidator::isNotNumeric);

        if (isNotNumericExists) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.NOT_NUMERIC.getError());
        }
    }

    private static boolean isNotNumeric(String target) {
        try {
            Integer.parseInt(target);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static void validateEachNumberIsInRange(List<String> target) {
        boolean isOutOfRangeNumberExists = target.stream()
                .map(Integer::parseInt)
                .anyMatch(element -> element < MIN_WINNING_NUMBER || element > MAX_WINNING_NUMBER);

        if (isOutOfRangeNumberExists) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.OUT_OF_RANGE.getError());
        }
    }

    private static void validateDuplicate(List<String> target) {
        Set<String> unique = new HashSet<>(target);
        if (unique.size() != target.size()) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.DUPLICATE_EXISTS.getError());
        }
    }


    private static void validateTotalCount(List<String> target) {
        if (target.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.INVALID_COUNT.getError());
        }
    }
}
