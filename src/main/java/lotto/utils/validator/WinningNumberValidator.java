package lotto.utils.validator;

import lotto.utils.message.WinningInformationExceptionMessage;

public class WinningNumberValidator {

    private static final int MAX_LENGTH = 20;

    public static void validate(String input) {
        validateBlank(input);
        validateSize(input);
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
}
