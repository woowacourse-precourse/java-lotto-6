package lotto.validator;

import lotto.util.ErrorMessage;

public class PurchaseAmountValidator {

    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validateMoney(String money, int divider){
        validateMoneyType(money);
        int purchaseMoney = Integer.parseInt(money);
        validateMoneyDivide(purchaseMoney, divider);
        validateMoneyNotMoreThanZero(purchaseMoney);
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
