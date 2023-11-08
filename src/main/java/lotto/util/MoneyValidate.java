package lotto.util;

import static lotto.constant.Constant.LOTTO_PRICE;

import lotto.constant.ErrorMessage;

public class MoneyValidate {
    public static void validateMoney(int money) {
        validateNumber(money);
        validateThousand(money);
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.toString());
        }
    }

    private static void validateThousand(int number) {
        if (number % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_THOUSAND.toString());
        }
    }
}
