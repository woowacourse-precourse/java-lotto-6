package lotto.validation;

import static lotto.SystemConstant.LOTTO_PRICE;
import static lotto.SystemConstant.MIN_PURCHASE_PRICE;
import static lotto.view.ErrorMessage.ILLEGAL_MONEY;

public class MoneyValidation {
    public static boolean validateMoney(String input) {
        isConvertibleToInt(input);
        int money = Integer.parseInt(input);
        isGreaterThanMinValue(money);
        isNotDivisibleBy(money);
        return true;
    }

    public static boolean isConvertibleToInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_MONEY.getMessage());
        }
        return true;
    }

    public static boolean isGreaterThanMinValue(int money) {
        if (money < MIN_PURCHASE_PRICE) {
            throw new IllegalArgumentException(ILLEGAL_MONEY.getMessage());
        }
        return true;
    }

    public static boolean isNotDivisibleBy(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ILLEGAL_MONEY.getMessage());
        }
        return true;
    }
}
