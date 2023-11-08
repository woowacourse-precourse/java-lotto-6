package lotto.validator;

import static lotto.constants.Constants.PURCHASE_NOT_NUMBER_MSG;
import static lotto.constants.Constants.PURCHASE_NOT_POSITIVE_MSG;
import static lotto.constants.Constants.PURCHASE_NOT_THOUSANDS_MSG;

public class PurcahseAmountValidator
{
    public static boolean validate(String purchaseAmount) {
        if(isNumber(purchaseAmount));
        if(isPositive(purchaseAmount));
        if(isThousands(purchaseAmount));
        return true;
    }
    public static boolean isNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_NOT_NUMBER_MSG);
        }
        return true;
    }
    public static boolean isPositive(String purchaseAmount) {
        int money = Integer.parseInt(purchaseAmount);
        if(money<0) {
            throw new IllegalArgumentException(PURCHASE_NOT_POSITIVE_MSG);
        }
        return true;
    }
    public static boolean isThousands(String purchaseAmount) {
        int money = Integer.parseInt(purchaseAmount);
        if(!(money%1000==0)) {
            throw new IllegalArgumentException(PURCHASE_NOT_THOUSANDS_MSG);
        }
        return true;
    }
}
