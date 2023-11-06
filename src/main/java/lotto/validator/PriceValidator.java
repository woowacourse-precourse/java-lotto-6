package lotto.validator;

import lotto.exception.ErrorMessage;

public class PriceValidator extends Validator{
    public final static int PURCHASE_COST = 1000;
    public final static int MAX_PURCHASE_COST = 100000;

    public static boolean validateCost(int cost){
        if(!validateNumberRange(cost, PURCHASE_COST, MAX_PURCHASE_COST)) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_OUT_OF_RANGE_MESSAGE.getMessage());
        }
        return true;
    }
    public static boolean validateThousand(int cost){
        if(cost%PURCHASE_COST!=0){
            throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_MESSAGE.getMessage());
        }
        return true;
    }
}
