package lotto.util;

import static lotto.domain.LottoMoney.MONEY_UNIT;
import static lotto.util.ErrorMessage.*;

public class Validator {

    private Validator() { }

    public static void validateMoney(int money) {
        checkPositive(money);
        checkUnit(money);
    }

    private static void checkPositive(int money) {
        if (isNotPositive(money)) {
            throw new IllegalArgumentException(NEGATIVE_INT_ERROR.getMessage());
        }
    }

    private static boolean isNotPositive(int money) {
        return money <= 0;
    }

    private static void checkUnit(int money) {
        if (money < MONEY_UNIT || money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
        }
    }

}
