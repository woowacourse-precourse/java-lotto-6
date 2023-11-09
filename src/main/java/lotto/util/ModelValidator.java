package lotto.util;

import java.util.List;
import lotto.exception.ModelExceptionConstant;

public class ModelValidator {
    public static void validateOutOfRange(int number, int startNumber, int endNumber) {
        if (number < startNumber || number > endNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.OUT_OF_LOTTO_NUMBER_RANGE.getText());
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ModelExceptionConstant.DUPLICATED_NUMBERS.getText());
        }
    }
}
