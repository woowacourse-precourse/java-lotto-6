package lotto.validate;

import lotto.message.ErrorMessage;

import static lotto.message.ErrorMessage.*;

public class Validator {
    public static void validatePurchaseMoney(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION.getMessage());
        }
        int purchaseMoney = Integer.parseInt(money);
        if (!isMultipleOf1000(purchaseMoney)) {
            throw new IllegalArgumentException(MULTIPLE_OF_THOUSAND_EXCEPTION.getMessage());
        }
        if (!isThousandOrMore(purchaseMoney)) {
            throw new IllegalArgumentException(THOUSAND_OR_MORE_EXCEPTION.getMessage());
        }
    }
    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    public static boolean isMultipleOf1000(int money) {
        return money % 1000 == 0;
    }

    public static boolean isThousandOrMore(int number) {
        return number >= 1000;
    }
}
