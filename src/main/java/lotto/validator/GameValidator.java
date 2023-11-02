package lotto.validator;

import static lotto.exception.ExceptionCase.MONEY_UNIT_MISMATCH;

public class GameValidator {
    public static void validateMoney(int money) {
        if (!isThousandWonUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_MISMATCH.message());
        }
    }

    private static boolean isThousandWonUnit(int money) {
        return money % 1000 == 0;
    }
}
