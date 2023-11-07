package lotto.util;

import lotto.exception.ModelExceptionConstant;

public class ModelValidator {
    public static void validateOutOfRange(int number, int startNumber, int endNumber) {
        if (number < startNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.OUT_OF_LOTTO_NUMBER_RANGE.getText());
        }

        if (number > endNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.OUT_OF_LOTTO_NUMBER_RANGE.getText());
        }
    }
}
