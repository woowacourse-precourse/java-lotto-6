package lotto.utils.validator;

import lotto.utils.message.WinningInformationExceptionMessage;

public class WinningNumberValidator {

    public static void validate(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.BLANK_WINNING_NUMBER.getError());
        }
    }
}
