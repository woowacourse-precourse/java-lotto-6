package lotto.validator;

import static lotto.constant.MessageConstants.CANNOT_INSTANTIATE;
import static lotto.constant.MessageConstants.ONLY_NUMBER;
import static lotto.constant.MessageConstants.OVER_MAX;
import static lotto.constant.NumberConstants.LOTTO_PRICE;
import static lotto.constant.NumberConstants.NOT_DIGIT;

public class InputValidator {

    private InputValidator() {
        throw new AssertionError(CANNOT_INSTANTIATE);
    }

    public static void validateMoney(String money) {
        if (isNotDigit(money)) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }

        if (isOverMax(money)) {
            throw new IllegalArgumentException(OVER_MAX);
        }
    }

    public static void validateBonusNumber(String number) {
        if (isNotDigit(number)) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

    private static boolean isNotDigit(String number) {
        return !number.matches(NOT_DIGIT);
    }

    private static boolean isOverMax(String money) {
        return Long.parseLong(money) > (Long.MAX_VALUE / LOTTO_PRICE) * LOTTO_PRICE;
    }

}
