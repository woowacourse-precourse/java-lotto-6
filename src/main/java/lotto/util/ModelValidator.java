package lotto.util;

import lotto.exception.ModelExceptionConstant;

public class ModelValidator {
    public static void validateOutOfRange(int number, int startNumber, int endNumber) {
        if (number < startNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.UNDER_LOTTO_START_NUMBER.getText());
        }

        if (number > endNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.UPPER_LOTTO_END_NUMBER.getText());
        }
    }
}
