package lotto.utils.validator;

import lotto.utils.message.WinningInformationExceptionMessage;

public class WinningNumberValidator {

    private static final int MAX_LENGTH = 20;
    private static final char COMMA = ',';

    public static void validate(String input) {
        validateBlank(input);
        validateSize(input);
        validateFirstCharacterIsComma(input);
        validateLastCharacterIsComma(input);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.BLANK_WINNING_NUMBER.getError());
        }
    }

    private static void validateSize(String target) {
        if (target.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.EXCEED_LENGTH.getError());
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
}
