package lotto.validator;

import lotto.system.ExceptionMessage;
import lotto.system.LottoNumberConstant;

public class BallValidator {
    public static void validate(int number) {
        validateRange(number);
    }

    private static void validateRange(int number) {
        if (isUnderRange(number) || isOverRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_RANGE.getMessage());
        }
    }

    private static boolean isUnderRange(int number) {
        return number < LottoNumberConstant.MIN.getValue();
    }

    private static boolean isOverRange(int number) {
        return number > LottoNumberConstant.MAX.getValue();
    }
}
