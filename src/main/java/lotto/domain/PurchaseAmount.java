package lotto.domain;

import lotto.util.ErrorMessage;

import static lotto.util.Constant.NUMBER_REGEX;

public class PurchaseAmount {

    public static int validateMoney(String money, int divider){
        validateMoneyType(money);
        int purchaseMoney = Integer.parseInt(money);
        validateMoneyNotMoreThanZero(purchaseMoney);
        validateMoneyDivide(purchaseMoney, divider);
        return purchaseMoney / divider;
    }

    public static void validateMoneyType(String money){
        if (!money.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(ErrorMessage.LOTTO_MUST_CONSIST_OF_NUMBERS);
        }
    }

    public static void validateMoneyDivide(int money, int divider) throws IllegalArgumentException {
        if(money % divider != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_DIVIDE_UNIT_ERROR);
        }
    }

    public static void validateMoneyNotMoreThanZero(int money){
        if(money <= 0){
            throw new IllegalArgumentException(ErrorMessage.CANT_BUY_NOT_MORE_THAN_ZERO);
        }
    }
}
