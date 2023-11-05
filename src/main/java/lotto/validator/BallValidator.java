package lotto.validator;

import lotto.system.ExceptionMessage;
import lotto.system.LottoNumberConstant;

public class BallValidator {
    public static void validate(int number) {
        validateRange(number);
    }

    private static void validateRange(int number) {
        if (number < LottoNumberConstant.MIN.getValue() || LottoNumberConstant.MAX.getValue() < number) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_RANGE.getMessage());
        }
    }
}
