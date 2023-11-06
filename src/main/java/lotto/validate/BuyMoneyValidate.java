package lotto.validate;

import static lotto.constants.ConstantValues.*;
import static lotto.constants.ErrorMessages.*;


public class BuyMoneyValidate {

    public static void validateBuyMoney(String buyMoney) {
        validateBuyMoneyIsEmpty(buyMoney);
        validateBuyMoneyIsNotNumber(buyMoney);
        int money = Integer.parseInt(buyMoney);
        validateBuyMoneyIsMinus(money);
        validateBuyMoneyIsNotThousand(money);
    }

    public static void validateBuyMoneyIsEmpty(String buyMoney) {
        if (buyMoney.isEmpty()) {
            throw new IllegalArgumentException(BUY_EMPTY_ERROR.getMessage());
        }
    }

    public static void validateBuyMoneyIsNotNumber(String buyMoney) {
        try {
            Integer.parseInt(buyMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BUY_CHAR_ERROR.getMessage());
        }
    }

    public static void validateBuyMoneyIsMinus(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(BUY_MINUS_ERROR.getMessage());
        }
    }

    public static void validateBuyMoneyIsNotThousand(int money) {
        if (money % LOTTO_COST.getValue() != 0) {
            throw new IllegalArgumentException(BUY_CONDITION_ERROR.getMessage());
        }
    }

}
