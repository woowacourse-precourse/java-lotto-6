package lotto.validator;

import static lotto.enums.ExceptionCase.INPUT_TYPE_MISMATCH;
import static lotto.enums.ExceptionCase.MONEY_UNIT_MISMATCH;
import static lotto.enums.NumberCondition.MONEY_UNIT;
import static lotto.enums.RegularExpression.POSITIVE_INTEGER;

public class UserValidator {
    public static void validateMoney(String money) {
        if (!isPositiveInteger(money)) {
            throw new IllegalArgumentException(INPUT_TYPE_MISMATCH.message());
        }
        if (!isCorrectUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_MISMATCH.message());
        }
    }

    private static boolean isPositiveInteger(String money) {
        return money.matches(POSITIVE_INTEGER.type());
    }

    private static boolean isCorrectUnit(String money) {
        return Integer.parseInt(money) % MONEY_UNIT.number() == 0;
    }
}
