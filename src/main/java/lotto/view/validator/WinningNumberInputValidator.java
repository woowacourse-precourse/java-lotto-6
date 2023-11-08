package lotto.view.validator;

import java.util.Arrays;
import java.util.List;
import lotto.utils.message.InputExceptionMessage;

public class WinningNumberInputValidator {
    private static final int MAX_LENGTH = 20;
    private static final char COMMA = ',';

    public static void validate(String input) {
        validateBlank(input);
        validateSize(input);
        validateFirstCharacterIsComma(input);
        validateLastCharacterIsComma(input);

        List<String> winningNumbers = Arrays.asList(input.split(","));
        validateEachNumberIsNumeric(winningNumbers);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(InputExceptionMessage.BLANK.getError());
        }
    }

    private static void validateSize(String target) {
        if (target.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    InputExceptionMessage.EXCEED_WINNING_NUMBER_LENGTH.getError());
        }
    }

    private static void validateFirstCharacterIsComma(String target) {
        if (target.charAt(0) == COMMA) {
            throw new IllegalArgumentException(InputExceptionMessage.FIRST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateLastCharacterIsComma(String target) {
        if (target.charAt(target.length() - 1) == COMMA) {
            throw new IllegalArgumentException(InputExceptionMessage.LAST_CHARACTER_COMMA.getError());
        }
    }

    private static void validateEachNumberIsNumeric(List<String> target) {
        boolean isNotNumericExists = target.stream()
                .anyMatch(WinningNumberInputValidator::isNotNumeric);

        if (isNotNumericExists) {
            throw new IllegalArgumentException(InputExceptionMessage.NOT_NUMERIC.getError());
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
}
