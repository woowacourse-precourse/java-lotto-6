package lotto.utils.validator;

import lotto.utils.message.WinningInformationExceptionMessage;

public class BonusNumberValidator {

    public static void validate(String target) {
        validateBlank(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(WinningInformationExceptionMessage.BLANK.getError());
        }
    }
}
