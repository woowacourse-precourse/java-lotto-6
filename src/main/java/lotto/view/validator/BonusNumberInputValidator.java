package lotto.view.validator;

import lotto.utils.message.InputExceptionMessage;

public class BonusNumberInputValidator {
    private static final int MAX_LENGTH = 2;

    public static void validate(String target) {
        validateBlank(target);
        validateMaxLength(target);
        validateNumeric(target);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(InputExceptionMessage.BLANK.getError());
        }
    }

    private static void validateMaxLength(String target) {
        if (target == null || target.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    InputExceptionMessage.EXCEED_BONUS_NUMBER_LENGTH.getError());
        }
    }

    private static void validateNumeric(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessage.NOT_NUMERIC.getError(), e);
        }
    }
}
