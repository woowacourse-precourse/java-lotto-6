package lotto.utils.validator;

import lotto.utils.message.WinningInformationExceptionMessage;

public class BonusNumberValidator {

    private static final int MAX_LENGTH = 2;
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    public static void validate(String target) {
        validateBlank(target);
        validateMaxLength(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.BLANK.getError());
        }
    }

    private static void validateMaxLength(String target) {
        if (target == null || target.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    WinningInformationExceptionMessage.EXCEED_BONUS_NUMBER_LENGTH.getError());
        }
    }
}
