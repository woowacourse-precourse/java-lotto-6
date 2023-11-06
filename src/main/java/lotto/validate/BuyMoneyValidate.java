package lotto.validate;

import static lotto.constants.ConstantValues.*;
import static lotto.constants.ErrorMessages.*;


public class BuyMoneyValidate {

    public static int validateBuyMoney(String buyMoney) {
        validateBuyMoneyIsEmpty(buyMoney);
        validateBuyMoneyIsNotNumber(buyMoney);
        int money = Integer.parseInt(buyMoney);
        validateBuyMoneyIsMinus(money);
        validateBuyMoneyIsNotThousand(money);
        return money;
    }

    public static void validateBuyMoneyIsEmpty(String buyMoney) {
        if (buyMoney.isEmpty()) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + BUY_EMPTY_ERROR.getMessage());
        }
    }

    public static void validateBuyMoneyIsNotNumber(String buyMoney) {
        try {
            Integer.parseInt(buyMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + BUY_CHAR_ERROR.getMessage());
        }
    }

    public static void validateBuyMoneyIsMinus(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + BUY_MINUS_ERROR.getMessage());
        }
    }

    public static void validateBuyMoneyIsNotThousand(int money) {
        if (money % LOTTO_COST.getValue() != 0) {
            throw new IllegalArgumentException(ERROR_HEADER.getMessage() + BUY_CONDITION_ERROR.getMessage());
        }
    }

}
