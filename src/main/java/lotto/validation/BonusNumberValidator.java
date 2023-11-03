package lotto.validation;

import lotto.enums.ErrorMessage;

public class BonusNumberValidator {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private BonusNumberValidator() {
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }
}
