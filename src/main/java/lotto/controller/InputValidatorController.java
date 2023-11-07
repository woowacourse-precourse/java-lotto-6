package lotto.controller;

import static lotto.utils.ErrorPhrase.*;
import static lotto.utils.LottoSystemUtils.moneyUnit;

public class InputValidatorController {

    public static void inputMoneyValidate(String money) {
        isDigit(money);
        isRightMoneyUnit(Integer.parseInt(money));
    }

    private static void isDigit(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(MONEY_IS_NOT_DIGIT_ERROR_PHRASE);
        }
    }

    private static void isRightMoneyUnit(int money) {
        if (money % moneyUnit != 0 || money == 0) {
            throw new IllegalArgumentException(MONEY_IS_WRONG_UNIT_ERROR_PHRASE);
        }
    }
}
